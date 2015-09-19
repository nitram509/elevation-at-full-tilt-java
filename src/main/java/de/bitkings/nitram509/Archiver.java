package de.bitkings.nitram509;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archiver implements Closeable {

  private static final long MAX = 100_000_000;
  private long estimatedFileSized = 0;
  private int indexCounter = 0;
  private TarArchiveOutputStream taos;
  private String baseName;

  public Archiver(String baseName) throws FileNotFoundException {
    this.baseName = baseName;
    createArchive();
  }

  private void createArchive() throws FileNotFoundException {
    String name = String.format("%s.%04d.tar", baseName, indexCounter);
    taos = new TarArchiveOutputStream(new FileOutputStream(name));
  }

  public void add(String name, byte[] data) throws IOException {
    splitArchiveIfRequired(data.length);
    TarArchiveEntry entry = new TarArchiveEntry(name);
    entry.setSize(data.length);
    entry.setMode(600);
    taos.putArchiveEntry(entry);
    taos.write(data);
    taos.closeArchiveEntry();
  }

  private void splitArchiveIfRequired(int length) throws IOException {
    if (estimatedFileSized + length > MAX) {
      taos.close();
      indexCounter++;
      createArchive();
    }
  }

  public void close() throws IOException {
    taos.close();
  }
}
