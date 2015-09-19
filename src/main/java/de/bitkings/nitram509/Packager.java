package de.bitkings.nitram509;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Packager {

  private static final String EXAMPLE = "/Users/martinki/srtm/http__e4ftl01.cr.usgs.gov__SRTM__SRTMGL3.003__2000.02.11/S56W071.SRTMGL3.hgt.zip";

  public static void main(String[] args) {
    try {
      Packager packager = new Packager();
      InputStream hgtStream = packager.openFromZipFile();
      byte[] hgtCompressed = packager.compressLz4(hgtStream);
      try (Archiver archiver = new Archiver("test")) {
        archiver.add("test", hgtCompressed);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private InputStream openFromZipFile() throws Exception {
    File hgtZipFile = new File(EXAMPLE);
    ZipInputStream zis = new ZipInputStream(new FileInputStream(hgtZipFile));
    ZipEntry nextEntry = zis.getNextEntry();
    assert nextEntry.getName().endsWith(".hgt");
    return zis;
  }

  private byte[] compressLz4(InputStream hgtStream) throws IOException {
    LZ4Factory factory = LZ4Factory.fastestInstance();
    byte[] hgtData = IOUtils.toByteArray(hgtStream);
    final int decompressedLength = hgtData.length;
    LZ4Compressor compressor = factory.highCompressor(9);
    int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
    byte[] compressed = new byte[maxCompressedLength];
    int compressedLength = compressor.compress(hgtData, 0, decompressedLength, compressed, 0, maxCompressedLength);
    return Arrays.copyOfRange(compressed, 0, compressedLength);
  }

}
