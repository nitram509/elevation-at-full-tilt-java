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
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Singleton
@Named
public class SrtmElevationService implements Closeable, ElevationService {

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
  public int getElevation(double latitude, double longitude) throws IOException {
    List tiles = spatialIndex.query(new Envelope(new Coordinate(longitude, latitude)));
    if (tiles.size() == 1) {
      SrtmTile tile = (SrtmTile) tiles.get(0);
      byte[] srtmTileData = getSrtmTileData(tile);
      calculateOffset(tile.boundingBox, latitude, longitude);
      return 1;
    }
    return Short.MIN_VALUE;
  }

  private void calculateOffset(BoundingBox boundingBox, double latitude, double longitude) {
//    dLat := math.Abs(lat - upperLeft[1])
//    dLon := math.Abs(lon - upperLeft[0])
//    distLat := math.Abs(upperLeft[1] - lowerRight[1])
//    distLon := math.Abs(upperLeft[0] - lowerRight[0])
//    nearestLat := int(dLat * float64(NO_OF_PIXELS_PER_LINE) / distLat);
//    nearestLon := int(dLon * float64(NO_OF_PIXELS_PER_LINE) / distLon)
//    return int64(NO_OF_PIXELS_PER_LINE * nearestLat + nearestLon) << 1
  }

//
//  func calculateUpperLeftAndLowerRightLikeGdalDataSet(boundingRectangle BoundingRectangle) (quadtree.Twof, quadtree.Twof) {
//    upperLeft := quadtree.Twof{
//      boundingRectangle.WestBoundingCoordinate + 0.5 / float64(NO_OF_PIXELS_PER_LINE - 1),
//          boundingRectangle.NorthBoundingCoordinate - 0.5 / float64(NO_OF_PIXELS_PER_LINE - 1),
//    }
//    lowerRight := quadtree.Twof{
//      boundingRectangle.EastBoundingCoordinate - 0.5 / float64(NO_OF_PIXELS_PER_LINE - 1),
//          boundingRectangle.SouthBoundingCoordinate + 0.5 / float64(NO_OF_PIXELS_PER_LINE - 1),
//    }
//    return upperLeft, lowerRight
//  }

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

  @Override
  public void close() throws IOException {
  }
}
