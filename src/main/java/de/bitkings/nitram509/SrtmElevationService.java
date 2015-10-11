package de.bitkings.nitram509;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.index.SpatialIndex;
import com.vividsolutions.jts.index.strtree.STRtree;
import de.bitkings.nitram509.srtm.SrtmTile;
import de.bitkings.nitram509.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.srtm.SrtmTileArchiveTocRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Singleton
@Named
public class SrtmElevationService implements Closeable, ElevationService {

  private static final File INDEX_FILE = new File("test" + TableOfContentBuilder.TOC_XML_FILE_EXTENSION);
  private SpatialIndex spatialIndex;

  public SrtmElevationService() {
    try {
      initSpatialIndex(readTileIndex());
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  private Collection<SrtmTile> readTileIndex() throws JAXBException {
    SrtmTileArchiveTocRepository srtmTileArchiveTocRepository = new SrtmTileArchiveTocRepository();
    SrtmTileArchiveToc srtmTileArchiveToc = srtmTileArchiveTocRepository.read(INDEX_FILE);
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
      Object o = tiles.get(0);
      return 1;
    }
    return -1;
  }

  @Override
  public void close() throws IOException {
  }
}
