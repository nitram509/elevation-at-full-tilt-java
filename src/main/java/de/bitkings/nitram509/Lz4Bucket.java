package de.bitkings.nitram509;

public class Lz4Bucket {

  final String name;
  final byte[] data;

  public Lz4Bucket(String name, byte[] data) {
    this.name = name;
    this.data = data;
  }
}
