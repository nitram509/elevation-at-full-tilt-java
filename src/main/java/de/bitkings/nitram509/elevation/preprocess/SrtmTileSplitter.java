package de.bitkings.nitram509.elevation.preprocess;

import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;

import java.util.Collection;

class SrtmTileSplitter {

  private SrtmTile tile;
  private byte[] srtmData;

  public SrtmTileSplitter(SrtmTile tile, byte[] srtmData) {
    this.tile = tile;
    this.srtmData = srtmData;
  }


  public void split() {

  }

  public Collection<SrtmTile> getTiles() {
    return null;
  }

  public Collection<byte[]> getData() {
    return null;
  }
}
