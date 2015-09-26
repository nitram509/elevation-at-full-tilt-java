package de.bitkings.nitram509.srtm;

import javafx.geometry.Rectangle2D;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "archiveLocatorId",
    "name",
    "boundingBox"
})
@XmlRootElement(name = "SrtmTile")
public class SrtmTile implements Serializable {
  public String name;
  public short archiveLocatorId;
  public BoundingBox boundingBox;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SrtmTile srtmTile = (SrtmTile) o;

    return !(name != null ? !name.equals(srtmTile.name) : srtmTile.name != null);

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
