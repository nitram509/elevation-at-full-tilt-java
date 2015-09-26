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

  public Map<String, SrtmTile> index = new HashMap<>();

}
