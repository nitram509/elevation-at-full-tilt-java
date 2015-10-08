package de.bitkings.nitram509;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.index.quadtree.Quadtree;
import de.bitkings.nitram509.srtm.SrtmTile;
import de.bitkings.nitram509.srtm.SrtmTileIndex;
import de.bitkings.nitram509.srtm.SrtmTileIndexRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Singleton
@Named
public class SrtmElevationService implements Closeable, ElevationService {

  private static final File INDEX_FILE = new File("test.index.xml");
  private Quadtree quadtree;

  public SrtmElevationService() {
    try {
      initQuadTree(readTileIndex());
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  private Collection<SrtmTile> readTileIndex() throws JAXBException {
    SrtmTileIndexRepository srtmTileIndexRepository = new SrtmTileIndexRepository();
    SrtmTileIndex srtmTileIndex = srtmTileIndexRepository.read(INDEX_FILE);
    return srtmTileIndex.getAll();
  }

  private void initQuadTree(Collection<SrtmTile> srtmTiles) throws JAXBException {
    quadtree = new Quadtree();
    for (SrtmTile srtmTile : srtmTiles) {
      Coordinate upperLeft = new Coordinate(srtmTile.boundingBox.west, srtmTile.boundingBox.north);
      Coordinate lowerRight = new Coordinate(srtmTile.boundingBox.east, srtmTile.boundingBox.south);
      Envelope envelope = new Envelope(upperLeft, lowerRight);
      quadtree.insert(envelope, srtmTile);
    }
  }

  @Override
  public int getElevation(double latitude, double longitude) throws IOException {
    return -1;
  }

  @Override
  public void close() throws IOException {
  }
}
