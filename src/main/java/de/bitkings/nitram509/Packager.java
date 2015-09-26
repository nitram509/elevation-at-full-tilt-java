package de.bitkings.nitram509;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Packager {

  private static final String EXAMPLE_FOLDER = "/Users/martinki/srtm/http__e4ftl01.cr.usgs.gov__SRTM__SRTMGL3.003__2000.02.11";
  private static final String EXAMPLE_FILE = "/Users/martinki/srtm/http__e4ftl01.cr.usgs.gov__SRTM__SRTMGL3.003__2000.02.11/S56W071.SRTMGL3.hgt.zip";

  public static void main(String[] args) {
    try {
      Packager packager = new Packager();
      packager.compressFilesFromFolder(EXAMPLE_FOLDER);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void compressFilesFromFolder(String basePath) throws Exception {
    File[] zipFiles = new File(basePath).listFiles(path -> {
      return path.getName().endsWith(".hgt.zip");
    });
    //compressFiles(zipFiles);
    determineDelta(zipFiles);
  }

  private void determineDelta(File[] zipFiles) throws Exception {
    for (File zipFile : zipFiles) {
      Lz4Bucket lz4Bucket = openFromZipFile(zipFile);
      analyze(lz4Bucket);
    }
  }

  private void analyze(Lz4Bucket lz4Bucket) {
    int min = 0;
    int max = 0;
    ByteBuffer hgt = ByteBuffer.wrap(lz4Bucket.data);
    for (int i = 0; i < (lz4Bucket.data.length - 1) / 2; i++) {
      int height1 = hgt.get(i * 2) & 0xff;
      int height2 = hgt.get(i * 2 + 1) & 0xff;
      int height = height1 << 8 | height2;
      min = Math.min(min, height);
      max = Math.max(max, height);
    }
    if (max - min < 256)
      System.out.println(String.format("min=%d,max=%d,delta=%d", min, max, max - min));
  }

  private void compressFiles(File[] zipFiles) throws Exception {
    try (Archiver archiver = new Archiver("test")) {
      for (File zipFile : zipFiles) {
        Lz4Bucket lz4Bucket = openFromZipFile(zipFile);
        byte[] hgtCompressed = compressLz4(lz4Bucket.data);
        archiver.add(lz4Bucket.name, hgtCompressed);
      }
    }
  }

  private Lz4Bucket openFromZipFile(File hgtZipFile) throws Exception {
    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(hgtZipFile))) {
      ZipEntry nextEntry = zis.getNextEntry();
      String name = nextEntry.getName();
      assert name.endsWith(".hgt");
      return new Lz4Bucket(name, IOUtils.toByteArray(zis));
    }
  }

  private byte[] compressLz4(byte[] hgtData) throws IOException {
    LZ4Factory factory = LZ4Factory.fastestInstance();
    final int decompressedLength = hgtData.length;
    LZ4Compressor compressor = factory.highCompressor(9);
    int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
    byte[] compressed = new byte[maxCompressedLength];
    int compressedLength = compressor.compress(hgtData, 0, decompressedLength, compressed, 0, maxCompressedLength);
    return Arrays.copyOfRange(compressed, 0, compressedLength);
  }

}
