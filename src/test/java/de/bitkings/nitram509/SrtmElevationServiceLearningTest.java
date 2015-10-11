package de.bitkings.nitram509;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class SrtmElevationServiceLearningTest {

  private SrtmElevationService service;

  @BeforeMethod
  public void setUp() throws Exception {
    service = new SrtmElevationService();
  }

  @Test
  public void loading_index_into_quadtree() throws Exception {
    int elevation = service.getElevation(52.13, 14.1);
    assertThat(elevation).isNotEqualTo(-1);
  }
}