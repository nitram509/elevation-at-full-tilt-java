package de.bitkings.nitram509.elevation.preprocess.srtm.metafile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class GranuleMetaDataFileReaderTest {

  private static final String EXAMPLE_HGT_XML_RESOURCE_PATH = "/N00E006.hgt.xml";

  private GranuleMetaDataFileReader reader;

  @BeforeMethod
  public void setUp() throws Exception {
    reader = new GranuleMetaDataFileReader();
  }

  @Test
  public void bounding_rectangle_can_be_read_via_JAXB_binding() throws Exception {
    GranuleMetaDataFile granuleMetaData = reader.read(getClass().getResourceAsStream(EXAMPLE_HGT_XML_RESOURCE_PATH));

    assertThat(granuleMetaData).isNotNull();
    GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle boundingRectangle = granuleMetaData.getGranuleURMetaData().getSpatialDomainContainer().getHorizontalSpatialDomainContainer().getBoundingRectangle();
    assertThat(boundingRectangle.getWestBoundingCoordinate()).isEqualTo(new BigDecimal("5.99916667"));
    assertThat(boundingRectangle.getNorthBoundingCoordinate()).isEqualTo(new BigDecimal("1.00083333"));
    assertThat(boundingRectangle.getEastBoundingCoordinate()).isEqualTo(new BigDecimal("7.00083333"));
    assertThat(boundingRectangle.getSouthBoundingCoordinate()).isEqualTo(new BigDecimal("-0.00083333"));
  }

}