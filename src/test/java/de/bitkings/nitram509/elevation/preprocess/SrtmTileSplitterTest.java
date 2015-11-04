package de.bitkings.nitram509.elevation.preprocess;

import de.bitkings.nitram509.elevation.preprocess.srtm.BoundingBox;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SrtmTileSplitterTest {

  private static final String TILE_NAME = "N52E013";

  private final byte[] data = new byte[2_884_802];
  private final SrtmTile tile = new SrtmTile();

  @BeforeMethod
  public void setUp() throws Exception {
    InputStream is = ClassLoader.getSystemResourceAsStream(TILE_NAME + ".hgt");
    is.read(data);
    is.close();

    tile.boundingBox = new BoundingBox(
        53.00083333,
        14.00083333,
        51.99916667,
        12.99916667
    );
    tile.archiveNumber = -1;
    tile.name = TILE_NAME;
  }

  @Test
  public void split_into_16_parts() throws Exception {
    SrtmTileSplitter splitter = new SrtmTileSplitter(tile, data);

    splitter.split();

    assertThat(splitter.getTiles()).hasSize(16);
    assertThat(splitter.getData()).hasSize(16);
  }
}