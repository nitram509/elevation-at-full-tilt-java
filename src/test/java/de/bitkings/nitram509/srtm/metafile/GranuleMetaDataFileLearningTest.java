package de.bitkings.nitram509.srtm.metafile;

import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class GranuleMetaDataFileLearningTest {

  private static final String EXAMPLE_HGT_XML_RESOURCE_PATH = "/N00E006.hgt.xml";

  @Test
  public void bounding_rectangle_can_be_read_via_JAXB_binding() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(GranuleMetaDataFile.class);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    GranuleMetaDataFile granuleMetaData = (GranuleMetaDataFile) unmarshaller.unmarshal(createNonValidatingXmlReader());

    assertThat(granuleMetaData).isNotNull();
    GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle boundingRectangle = granuleMetaData.getGranuleURMetaData().getSpatialDomainContainer().getHorizontalSpatialDomainContainer().getBoundingRectangle();
    assertThat(boundingRectangle.getWestBoundingCoordinate()).isEqualTo(new BigDecimal("5.99916667"));
    assertThat(boundingRectangle.getNorthBoundingCoordinate()).isEqualTo(new BigDecimal("1.00083333"));
    assertThat(boundingRectangle.getEastBoundingCoordinate()).isEqualTo(new BigDecimal("7.00083333"));
    assertThat(boundingRectangle.getSouthBoundingCoordinate()).isEqualTo(new BigDecimal("-0.00083333"));
  }

  private SAXSource createNonValidatingXmlReader() throws ParserConfigurationException, SAXException {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    spf.setFeature("http://xml.org/sax/features/validation", false);
    XMLReader xmlReader = spf.newSAXParser().getXMLReader();
    InputStream is = getClass().getResourceAsStream(EXAMPLE_HGT_XML_RESOURCE_PATH);
    return new SAXSource(xmlReader, new InputSource(is));
  }

}