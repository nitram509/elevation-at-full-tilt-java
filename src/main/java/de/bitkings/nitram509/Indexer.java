package de.bitkings.nitram509;

import de.bitkings.nitram509.srtm.SrtmTile;
import de.bitkings.nitram509.srtm.SrtmTileIndex;
import de.bitkings.nitram509.srtm.SrtmTileIndexRepository;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

class Indexer {

  private final SrtmTileIndex srtmTileIndex;
  private String baseName;

  public Indexer(String baseName) throws FileNotFoundException {
    this.baseName = baseName;
    this.srtmTileIndex = new SrtmTileIndex();
  }

  public void add(SrtmTile srtmTile) {
    srtmTileIndex.put(srtmTile.name, srtmTile);
  }

  public void persistIndex() {
    try {
      SrtmTileIndexRepository indexRepository = new SrtmTileIndexRepository();
      indexRepository.write(srtmTileIndex, new File(baseName + ".index.xml"));
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

}
