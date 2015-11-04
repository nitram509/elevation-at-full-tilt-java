package de.bitkings.nitram509.elevation.preprocess.srtm;

public class SrtmTile {
  public String name;
  public short archiveNumber;
  public BoundingBox boundingBox;

  public SrtmTile() {
  }

  public SrtmTile(String name, short archiveNumber, BoundingBox boundingBox) {
    this.name = name;
    this.archiveNumber = archiveNumber;
    this.boundingBox = boundingBox;
  }

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
