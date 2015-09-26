package de.bitkings.nitram509.srtm;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SrtmTileIndexRepository {

  private final JAXBContext context;

  public SrtmTileIndexRepository() throws JAXBException {
    context = JAXBContext.newInstance(SrtmTileIndex.class, SrtmTile.class);
  }

  public void write(SrtmTileIndex srtmTileIndex, File file) throws JAXBException {
    Marshaller marshaller = context.createMarshaller();
    marshaller.marshal(srtmTileIndex, file);
  }

  public SrtmTileIndex read(File file) throws JAXBException {
    Unmarshaller marshaller = context.createUnmarshaller();
    return (SrtmTileIndex) marshaller.unmarshal(file);
  }
}
