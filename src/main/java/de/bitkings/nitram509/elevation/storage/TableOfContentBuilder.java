package de.bitkings.nitram509.elevation.storage;

import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveTocRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class TableOfContentBuilder {

  static final String TOC_FILE_EXTENSION = ".toc.geojson";

  private final SrtmTileArchiveToc srtmTileArchiveToc;
  private String baseName;

  public TableOfContentBuilder(String baseName) throws FileNotFoundException {
    this.baseName = baseName;
    this.srtmTileArchiveToc = new SrtmTileArchiveToc();
  }

  public void add(SrtmTile srtmTile) {
    srtmTileArchiveToc.put(srtmTile.name, srtmTile);
  }

  public void persistIndex() {
    try {
      SrtmTileArchiveTocRepository indexRepository = new SrtmTileArchiveTocRepository();
      indexRepository.write(srtmTileArchiveToc, new File(baseName + TOC_FILE_EXTENSION));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
