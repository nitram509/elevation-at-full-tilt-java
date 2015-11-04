package de.bitkings.nitram509.elevation.preprocess.srtm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class SrtmTileArchiveTocRepositoryTest {

  private SrtmTileArchiveTocRepository repository;
  private File tempFile;

  @BeforeMethod
  public void setUp() throws Exception {
    repository = new SrtmTileArchiveTocRepository();
    tempFile = File.createTempFile("srtm.tile.index", ".geojson");
    tempFile.deleteOnExit();
  }

  @Test
  public void index_can_be_written_and_read_back_again() throws Exception {
    SrtmTileArchiveToc expectedIndex = new SrtmTileArchiveToc();
    expectedIndex.put("FOO", createTestTile());
    repository.write(expectedIndex, tempFile);
    assertThat(Files.size(tempFile.toPath())).describedAs(tempFile.getAbsolutePath()).isGreaterThan(0);

    SrtmTileArchiveToc actualIndex = repository.read(tempFile);
    assertThat(actualIndex).describedAs(tempFile.getAbsolutePath()).isNotNull();

    SrtmTile actualTile = actualIndex.get("FOO");
    SrtmTile expectedTile = expectedIndex.get("FOO");
    assertThat(actualTile).isEqualTo(expectedTile);
    assertThat(actualTile.boundingBox).isEqualTo(expectedTile.boundingBox);
  }

  private SrtmTile createTestTile() {
    SrtmTile tile = new SrtmTile();
    tile.name = "FOO";
    tile.archiveNumber = 123;
    tile.boundingBox = new BoundingBox(1, 2, 3, 4);
    return tile;
  }
}