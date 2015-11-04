package de.bitkings.nitram509.elevation.preprocess.srtm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;

import java.io.File;
import java.io.IOException;

public class SrtmTileArchiveTocRepository {

  private final SrtmTileArchiveTocSerializer serializer = new SrtmTileArchiveTocSerializer();
  private final SrtmTileArchiveTocDeSerializer deSerializer = new SrtmTileArchiveTocDeSerializer();

  public void write(SrtmTileArchiveToc srtmTileArchiveToc, File file) throws IOException {
    new ObjectMapper().writeValue(file, serializer.toGeoJson(srtmTileArchiveToc));
  }

  public SrtmTileArchiveToc read(File file) throws IOException {
    FeatureCollection featureCollection = new ObjectMapper().readValue(file, FeatureCollection.class);
    return deSerializer.fromGeoJson(featureCollection);
  }

}
