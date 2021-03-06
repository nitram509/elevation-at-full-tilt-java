package de.bitkings.nitram509.elevation.storage;

import java.io.File;

public class ArchiveNamer {

  private static final String TOC_FILE_EXTENSION = ".toc.geojson";

  private final String baseName;

  public ArchiveNamer(String baseName) {
    this.baseName = baseName;
  }

  public String getTocFileName() {
    return baseName + TOC_FILE_EXTENSION;
  }

  public File getTocFile() {
    return new File(getTocFileName());
  }

  public String getArchiveFileName(short archiveNumber) {
    return String.format("%s.%04d.tar", baseName, archiveNumber);
  }

  public String getArchiveFileName(int archiveNumber) {
    return String.format("%s.%04d.tar", baseName, archiveNumber);
  }

  public File getArchiveFile(short archiveNumber) {
    return new File(getArchiveFileName(archiveNumber));
  }
}
