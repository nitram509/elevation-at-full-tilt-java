package de.bitkings.nitram509.elevation.storage;

public class Lz4Bucket {

  public final String name;
  public final byte[] data;

  public Lz4Bucket(String name, byte[] data) {
    this.name = name;
    this.data = data;
  }
}
