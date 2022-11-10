package de.bitkings.nitram509.elevation.preprocess;

import de.bitkings.nitram509.elevation.preprocess.srtm.BoundingBox;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;

import java.util.Collection;

class SrtmTileSplitter {
  private static double NO_OF_PIXELS_PER_LINE = 1201;

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
    BoundingRect rect = calculateUpperLeftAndLowerRightLikeGdalDataSet(tile.boundingBox);

    return null;
  }

  private int calculateOffset(BoundingBox boundingBox, double latitude, double longitude) {
    final BoundingRect rect = calculateUpperLeftAndLowerRightLikeGdalDataSet(boundingBox);
    final double dLat = Math.abs(latitude - rect.upperLeft[1]);
    final double dLon = Math.abs(longitude - rect.upperLeft[0]);
    final double distLat = Math.abs(rect.upperLeft[1] - rect.lowerRight[1]);
    final double distLon = Math.abs(rect.upperLeft[0] - rect.lowerRight[0]);
    final long snapToLat = (long) (dLat * NO_OF_PIXELS_PER_LINE / distLat);
    final long snapToLon = (long) (dLon * NO_OF_PIXELS_PER_LINE / distLon);
    return (int) (((long) (NO_OF_PIXELS_PER_LINE)) * snapToLat + snapToLon) << 1;
  }

  private BoundingRect calculateUpperLeftAndLowerRightLikeGdalDataSet(BoundingBox boundingBox) {
    return new BoundingRect(
        new double[]{boundingBox.west + 0.5 / (NO_OF_PIXELS_PER_LINE - 1), boundingBox.north - 0.5 / (NO_OF_PIXELS_PER_LINE - 1)},
        new double[]{boundingBox.east - 0.5 / (NO_OF_PIXELS_PER_LINE - 1), boundingBox.south + 0.5 / (NO_OF_PIXELS_PER_LINE - 1)}
    );
  }

  private static class BoundingRect {
    private final double[] upperLeft;
    private final double[] lowerRight;

    public BoundingRect(double[] upperLeft, double[] lowerRight) {
      this.upperLeft = upperLeft;
      this.lowerRight = lowerRight;
    }
  }
}
