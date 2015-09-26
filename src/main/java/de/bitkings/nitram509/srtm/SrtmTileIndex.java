package de.bitkings.nitram509.srtm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "index",
})
@XmlRootElement(name = "SrtmTileIndex")
public class SrtmTileIndex implements Serializable {

  private Map<String, SrtmTile> index = new HashMap<>();

  public SrtmTile get(String key) {
    return index.get(key);
  }

  public SrtmTile put(String key, SrtmTile value) {
    return index.put(key, value);
  }

  public SrtmTile remove(String key) {
    return index.remove(key);
  }
}
