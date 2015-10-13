package de.bitkings.nitram509.elevation.preprocess.srtm;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SrtmTileArchiveTocRepository {

  private final JAXBContext context;

  public SrtmTileArchiveTocRepository() throws JAXBException {
    context = JAXBContext.newInstance(SrtmTileArchiveToc.class, SrtmTile.class);
  }

  public void write(SrtmTileArchiveToc srtmTileArchiveToc, File file) throws JAXBException {
    Marshaller marshaller = context.createMarshaller();
    marshaller.marshal(srtmTileArchiveToc, file);
  }

  public SrtmTileArchiveToc read(File file) throws JAXBException {
    Unmarshaller marshaller = context.createUnmarshaller();
    return (SrtmTileArchiveToc) marshaller.unmarshal(file);
  }
}
