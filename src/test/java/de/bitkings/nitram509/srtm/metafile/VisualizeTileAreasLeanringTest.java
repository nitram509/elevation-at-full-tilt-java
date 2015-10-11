package de.bitkings.nitram509.srtm.metafile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.testng.annotations.Test;

public class VisualizeTileAreasLeanringTest {
  @Test
  public void convert_xml_meta_data_to_geojson() throws Exception {
    FeatureCollection featureCollection = new FeatureCollection();
    featureCollection.add(new Feature());

    String json= new ObjectMapper().writeValueAsString(featureCollection);

    System.out.println(json);

  }
}
