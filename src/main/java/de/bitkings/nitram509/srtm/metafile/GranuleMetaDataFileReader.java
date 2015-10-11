package de.bitkings.nitram509.srtm.metafile;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.InputStream;

public class GranuleMetaDataFileReader {

  private final JAXBContext context;

  public GranuleMetaDataFileReader() {
    try {
      context = JAXBContext.newInstance(GranuleMetaDataFile.class);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  public GranuleMetaDataFile read(InputStream xml) throws JAXBException, ParserConfigurationException, SAXException {
    Unmarshaller unmarshaller = context.createUnmarshaller();
    return (GranuleMetaDataFile) unmarshaller.unmarshal(createNonValidatingXmlReader(xml));
  }

  private SAXSource createNonValidatingXmlReader(InputStream xml) throws ParserConfigurationException, SAXException {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    spf.setFeature("http://xml.org/sax/features/validation", false);
    XMLReader xmlReader = spf.newSAXParser().getXMLReader();
    return new SAXSource(xmlReader, new InputSource(xml));
  }
}
