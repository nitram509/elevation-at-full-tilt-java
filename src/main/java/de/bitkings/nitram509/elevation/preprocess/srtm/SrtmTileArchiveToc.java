package de.bitkings.nitram509.elevation.preprocess.srtm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SrtmTileArchiveToc {

  private Map<String, SrtmTile> index = new HashMap<>();

  public SrtmTile get(String key) {
    return index.get(key);
  }

  public Collection<SrtmTile> getAll() {
    return index.values();
  }

  public SrtmTile put(String key, SrtmTile value) {
    return index.put(key, value);
  }

  public SrtmTile remove(String key) {
    return index.remove(key);
  }
}
