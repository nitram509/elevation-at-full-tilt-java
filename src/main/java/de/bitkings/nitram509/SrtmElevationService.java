package de.bitkings.nitram509;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.index.SpatialIndex;
import com.vividsolutions.jts.index.strtree.STRtree;
import de.bitkings.nitram509.srtm.BoundingBox;
import de.bitkings.nitram509.srtm.SrtmTile;
import de.bitkings.nitram509.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.srtm.SrtmTileArchiveTocRepository;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

@Singleton
@Named
public class SrtmElevationService implements ElevationService {

  private static double NO_OF_PIXELS_PER_LINE = 1201;

  private SpatialIndex spatialIndex;

  private final ArchiveNamer archiveNamer = new ArchiveNamer("test");
  private final LZ4Factory factory;

  public SrtmElevationService() {
    try {
      initSpatialIndex(readTileIndex());
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    factory = LZ4Factory.fastestInstance();
  }

  private Collection<SrtmTile> readTileIndex() throws JAXBException {
    SrtmTileArchiveTocRepository srtmTileArchiveTocRepository = new SrtmTileArchiveTocRepository();
    SrtmTileArchiveToc srtmTileArchiveToc = srtmTileArchiveTocRepository.read(archiveNamer.getTocFile());
    return srtmTileArchiveToc.getAll();
  }

  private void initSpatialIndex(Collection<SrtmTile> srtmTiles) throws JAXBException {
    spatialIndex = new STRtree();
    for (SrtmTile srtmTile : srtmTiles) {
      Coordinate upperLeft = new Coordinate(srtmTile.boundingBox.west, srtmTile.boundingBox.north);
      Coordinate lowerRight = new Coordinate(srtmTile.boundingBox.east, srtmTile.boundingBox.south);
      Envelope envelope = new Envelope(upperLeft, lowerRight);
      spatialIndex.insert(envelope, srtmTile);
    }
  }

  @Override
  public int getElevation(double latitude, double longitude) throws IOException, NoSuchAlgorithmException {
    List tiles = spatialIndex.query(new Envelope(new Coordinate(longitude, latitude)));
    if (tiles.size() == 1) {
      SrtmTile tile = (SrtmTile) tiles.get(0);
      byte[] srtmTileData = getSrtmTileData(tile);
      if (srtmTileData != null && srtmTileData.length > 1) {
        int offset = calculateOffset(tile.boundingBox, latitude, longitude);
        return ((int) srtmTileData[offset] & 0xff) << 8 | (int) srtmTileData[offset + 1] & 0xff;
      }
    }
    return Short.MIN_VALUE;
  }

  private int calculateOffset(BoundingBox boundingBox, double latitude, double longitude) {
    BoundingRect rect = calculateUpperLeftAndLowerRightLikeGdalDataSet(boundingBox);
    double dLat = Math.abs(latitude - rect.upperLeft[1]);
    double dLon = Math.abs(longitude - rect.upperLeft[0]);
    double distLat = Math.abs(rect.upperLeft[1] - rect.lowerRight[1]);
    double distLon = Math.abs(rect.upperLeft[0] - rect.lowerRight[0]);
    long nearestLat = (long) (dLat * NO_OF_PIXELS_PER_LINE / distLat);
    long nearestLon = (long) (dLon * NO_OF_PIXELS_PER_LINE / distLon);
    return (int) (((long) (NO_OF_PIXELS_PER_LINE)) * nearestLat + nearestLon) << 1;
  }

  private byte[] getSrtmTileData(SrtmTile tile) throws IOException {
    File tarFile = archiveNamer.getArchiveFile(tile.archiveNumber);
    TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(tarFile));
    for (TarArchiveEntry tae; (tae = tais.getNextTarEntry()) != null; ) {
      if (!tae.getName().startsWith(tile.name)) continue;
      byte[] buf = new byte[(int) tae.getSize()];
      assert tais.read(buf) > 0;
      return decompress(buf);
    }
    return null;
  }

  private byte[] decompress(byte[] buf) {
    LZ4FastDecompressor decompressor = factory.fastDecompressor();
    byte[] uncompressed = new byte[2_884_802];
    decompressor.decompress(buf, uncompressed);
    return uncompressed;
  }

  private BoundingRect calculateUpperLeftAndLowerRightLikeGdalDataSet(BoundingBox boundingBox) {
    return new BoundingRect(
        new double[]{boundingBox.west + 0.5 / (NO_OF_PIXELS_PER_LINE - 1), boundingBox.north - 0.5 / (NO_OF_PIXELS_PER_LINE - 1)},
        new double[]{boundingBox.east - 0.5 / (NO_OF_PIXELS_PER_LINE - 1), boundingBox.south + 0.5 / (NO_OF_PIXELS_PER_LINE - 1)}
    );
  }

  private static class BoundingRect {
    private final double[] upperLeft;
    private final double[] lowerRight;

    public BoundingRect(double[] upperLeft, double[] lowerRight) {
      this.upperLeft = upperLeft;
      this.lowerRight = lowerRight;
    }
  }
}
