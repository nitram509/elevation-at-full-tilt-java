package de.bitkings.nitram509.elevation.preprocess.srtm;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "north",
    "east",
    "south",
    "west",
})
@XmlRootElement(name = "box")
public class BoundingBox {

  @XmlAttribute(name = "north")
  public double north;

  @XmlAttribute(name = "east")
  public double east;

  @XmlAttribute(name = "south")
  public double south;

  @XmlAttribute(name = "west")
  public double west;

  public BoundingBox() {
  }

  public BoundingBox(double north, double east, double south, double west) {
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BoundingBox that = (BoundingBox) o;

    if (Double.compare(that.north, north) != 0) return false;
    if (Double.compare(that.east, east) != 0) return false;
    if (Double.compare(that.south, south) != 0) return false;
    return Double.compare(that.west, west) == 0;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(north);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(east);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(south);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(west);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
