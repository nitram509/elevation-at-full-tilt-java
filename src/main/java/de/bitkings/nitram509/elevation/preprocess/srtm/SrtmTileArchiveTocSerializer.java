package de.bitkings.nitram509.elevation.preprocess.srtm;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Polygon;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

class SrtmTileArchiveTocSerializer {

  public static final String PROPERTY_KEY_NAME = "name";
  public static final String PROPERTY_KEY_ARCHIVE_NR = "archiveNumber";

  public FeatureCollection toGeoJson(SrtmTileArchiveToc toc) {
    FeatureCollection featureCollection = new FeatureCollection();
    for (SrtmTile srtmTile : sortByName(toc.getAll())) {
      featureCollection.add(createFeature(srtmTile));
    }
    return featureCollection;
  }

  private List<SrtmTile> sortByName(Collection<SrtmTile> tiles) {
    return tiles.stream().sorted((tile1, tile2) -> tile1.name.compareTo(tile2.name)).collect(toList());
  }

  private Feature createFeature(SrtmTile srtmTile) {
    Feature feature = new Feature();
    Polygon polygon = new Polygon();
    if (srtmTile.boundingBox != null) {
      polygon.setBbox(new double[]{
          srtmTile.boundingBox.north,
          srtmTile.boundingBox.east,
          srtmTile.boundingBox.south,
          srtmTile.boundingBox.west,
      });
      polygon.setCoordinates(singletonList(asList(
          new LngLatAlt(srtmTile.boundingBox.east, srtmTile.boundingBox.north),
          new LngLatAlt(srtmTile.boundingBox.east, srtmTile.boundingBox.south),
          new LngLatAlt(srtmTile.boundingBox.west, srtmTile.boundingBox.south),
          new LngLatAlt(srtmTile.boundingBox.west, srtmTile.boundingBox.north),
          new LngLatAlt(srtmTile.boundingBox.east, srtmTile.boundingBox.north)
      )));
    }
    feature.setGeometry(polygon);
    feature.setProperty(PROPERTY_KEY_NAME, srtmTile.name);
    feature.setProperty(PROPERTY_KEY_ARCHIVE_NR, srtmTile.archiveNumber);
    return feature;
  }

}
