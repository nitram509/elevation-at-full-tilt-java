package de.bitkings.nitram509;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archiver implements Closeable {

  private long estimatedFileSized = 0;
  private final TarArchiveOutputStream taos;

  public Archiver(String fileName) throws FileNotFoundException {
    if (!fileName.endsWith(".tar")) {
      fileName = fileName + ".tar";
    }
    taos = new TarArchiveOutputStream(new FileOutputStream(fileName));
  }

  public void add(String name, byte[] data) throws IOException {
    TarArchiveEntry entry = new TarArchiveEntry(name);
    entry.setSize(data.length);
    entry.setMode(600);
    taos.putArchiveEntry(entry);
    taos.write(data);
    taos.closeArchiveEntry();
  }

  public void close() throws IOException {
    taos.close();
  }
}
