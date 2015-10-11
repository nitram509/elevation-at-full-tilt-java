package de.bitkings.nitram509;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class SrtmElevationServiceTest {

  private SrtmElevationService service;

  @BeforeMethod
  public void setUp() throws Exception {
    service = new SrtmElevationService();
  }

  @DataProvider
  public static Object[][] resolve_elevation_for_well_known_coordinates() {
    return new Object[][]{
        new Double[]{50.918961, 14.057732, 355d},
        new Double[]{50.851495, 14.301564, 305d},
        new Double[]{50.4163577778, 14.9198269444, 216d}
    };
  }

  @Test(dataProvider = "resolve_elevation_for_well_known_coordinates")
  public void loading_index_into_quadtree(double latitude, double longitude, double expectedHeight) throws Exception {
    int elevation = service.getElevation(latitude, longitude);
    assertThat(elevation).isEqualTo((int) expectedHeight);
  }
}