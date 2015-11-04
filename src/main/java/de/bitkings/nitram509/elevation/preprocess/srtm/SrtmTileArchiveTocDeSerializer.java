package de.bitkings.nitram509.elevation.preprocess.srtm;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;

import static de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveTocSerializer.PROPERTY_KEY_ARCHIVE_NR;
import static de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveTocSerializer.PROPERTY_KEY_NAME;

class SrtmTileArchiveTocDeSerializer {

  public SrtmTileArchiveToc fromGeoJson(FeatureCollection features) {
    SrtmTileArchiveToc toc = new SrtmTileArchiveToc();
    features.iterator().forEachRemaining(feature -> {
      SrtmTile tile = createSrtmTile(feature);
      toc.put(tile.name, tile);
    });
    return toc;
  }

  private SrtmTile createSrtmTile(Feature feature) {
    String name = feature.getProperty(PROPERTY_KEY_NAME);
    int archiveNumber = feature.getProperty(PROPERTY_KEY_ARCHIVE_NR);
    BoundingBox bbox = mapBbox(feature.getGeometry());
    return new SrtmTile(name, (short) archiveNumber, bbox);
  }

  private BoundingBox mapBbox(GeoJsonObject geoJsonObject) {
    double[] bbox = geoJsonObject.getBbox();
    return new BoundingBox(
        bbox[0],
        bbox[1],
        bbox[2],
        bbox[3]
    );
  }

}
