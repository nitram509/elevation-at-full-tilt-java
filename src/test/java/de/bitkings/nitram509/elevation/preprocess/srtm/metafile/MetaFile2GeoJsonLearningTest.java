package de.bitkings.nitram509.elevation.preprocess.srtm.metafile;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bitkings.nitram509.elevation.storage.Packager;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Polygon;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class MetaFile2GeoJsonLearningTest {

  private GranuleMetaDataFileReader granuleMetaDataFileReader;
  private File[] allXmlMetaDataFiles;

  @BeforeMethod
  public void setUp() throws Exception {
    granuleMetaDataFileReader = new GranuleMetaDataFileReader();
    allXmlMetaDataFiles = findAllXmlMetaDataFiles();
  }

  @Test(enabled = false) // was just used for visualizing the bounding boxes on http://geojson.io
  public void convert_xml_meta_data_to_geojson() throws Exception {

    FeatureCollection featureCollection = new FeatureCollection();

    for (File metaDataFile : filter(allXmlMetaDataFiles, f -> f.getName().startsWith("N52"))) {
      InputStream inputStream = new BufferedInputStream(new FileInputStream(metaDataFile));
      GranuleMetaDataFile granuleMetaDataFile = granuleMetaDataFileReader.read(inputStream);
      inputStream.close();
      featureCollection.add(createFeature(
          granuleMetaDataFile.getGranuleURMetaData().getSpatialDomainContainer().getHorizontalSpatialDomainContainer().getBoundingRectangle(),
          granuleMetaDataFile.getGranuleURMetaData().getECSDataGranule().getLocalGranuleID().replace(".SRTMGL3.hgt.zip", "")
      ));
    }

    System.out.println(new ObjectMapper().writeValueAsString(featureCollection));
  }

  private File[] filter(File[] allXmlMetaDataFiles, Predicate<? super File> predicate) {
    List<File> collect = Arrays.asList(allXmlMetaDataFiles).stream()
        .filter(predicate)
        .collect(toList());
    return collect.toArray(new File[collect.size()]);
  }

  private File[] findAllXmlMetaDataFiles() {
    File[] files = new File(Packager.EXAMPLE_FOLDER).listFiles(path -> {
      String fname = path.getName().toLowerCase();
      return fname.endsWith(".xml");
    });
    Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
    return files;
  }

  private Feature createFeature(GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle boundingRectangle, String name) {
    Feature feature = new Feature();
    Polygon polygon = new Polygon();
    polygon.setCoordinates(singletonList(asList(
        new LngLatAlt(boundingRectangle.getEastBoundingCoordinate().doubleValue(), boundingRectangle.getNorthBoundingCoordinate().doubleValue()),
        new LngLatAlt(boundingRectangle.getEastBoundingCoordinate().doubleValue(), boundingRectangle.getSouthBoundingCoordinate().doubleValue()),
        new LngLatAlt(boundingRectangle.getWestBoundingCoordinate().doubleValue(), boundingRectangle.getSouthBoundingCoordinate().doubleValue()),
        new LngLatAlt(boundingRectangle.getWestBoundingCoordinate().doubleValue(), boundingRectangle.getNorthBoundingCoordinate().doubleValue()),
        new LngLatAlt(boundingRectangle.getEastBoundingCoordinate().doubleValue(), boundingRectangle.getNorthBoundingCoordinate().doubleValue())
    )));
    feature.setGeometry(polygon);
    feature.setProperty("name", name);
    return feature;
  }
}
