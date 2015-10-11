package de.bitkings.nitram509;

import de.bitkings.nitram509.srtm.SrtmTile;
import de.bitkings.nitram509.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.srtm.SrtmTileArchiveTocRepository;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

class TableOfContentBuilder {

  public static final String TOC_XML_FILE_EXTENSION = ".toc.xml";

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
      indexRepository.write(srtmTileArchiveToc, new File(baseName + TOC_XML_FILE_EXTENSION));
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

}
