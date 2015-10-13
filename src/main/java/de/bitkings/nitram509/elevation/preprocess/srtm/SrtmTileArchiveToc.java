package de.bitkings.nitram509.elevation.preprocess.srtm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "index",
})
@XmlRootElement(name = "SrtmTileIndex")
public class SrtmTileArchiveToc implements Serializable {

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
