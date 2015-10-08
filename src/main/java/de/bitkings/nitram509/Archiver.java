package de.bitkings.nitram509;

import de.bitkings.nitram509.srtm.BoundingBox;
import de.bitkings.nitram509.srtm.SrtmTile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Archiver implements Closeable {

  private static final long MAX_ARCHIVE_SIZE = 100_000_000;
  private final Indexer indexer;
  private long estimatedFileSized = 0;
  private int currentArchiveNumber = 0;
  private TarArchiveOutputStream taos;
  private String baseName;

  public Archiver(String baseName) throws FileNotFoundException {
    this.baseName = baseName;
    this.indexer = new Indexer(baseName);
    createArchive();
  }

  private void createArchive() throws FileNotFoundException {
    String name = String.format("%s.%04d.tar", baseName, currentArchiveNumber);
    taos = new TarArchiveOutputStream(new FileOutputStream(name));
  }

  public void add(String name, byte[] data, BoundingBox boundingBox) throws IOException {
    System.out.println("Adding " + name);
    splitArchiveIfRequired(data.length);
    TarArchiveEntry entry = new TarArchiveEntry(name);
    entry.setSize(data.length);
    entry.setMode(600);
    taos.putArchiveEntry(entry);
    taos.write(data);
    taos.closeArchiveEntry();
    String key = name.substring(0, name.length() - 4);
    indexer.add(new SrtmTile(key, (short) currentArchiveNumber, boundingBox));
  }

  private void splitArchiveIfRequired(int length) throws IOException {
    if (estimatedFileSized + length > MAX_ARCHIVE_SIZE) {
      taos.close();
      currentArchiveNumber++;
      estimatedFileSized = 0;
      createArchive();
    } else {
      estimatedFileSized = estimatedFileSized + length;
    }
  }

  public void close() throws IOException {
    taos.close();
    indexer.persistIndex();
  }

}
