package de.bitkings.nitram509.elevation.storage;

import de.bitkings.nitram509.elevation.preprocess.srtm.BoundingBox;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveTocRepository;
import de.bitkings.nitram509.elevation.preprocess.srtm.metafile.GranuleMetaDataFile;
import de.bitkings.nitram509.elevation.preprocess.srtm.metafile.GranuleMetaDataFileReader;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class TableOfContentReBuilder {

  private static String BASE_PATH_FOR_SRTM_DATA = System.getProperty("user.home") + "/srtm/http__e4ftl01.cr.usgs.gov__SRTM__SRTMGL3.003__2000.02.11";

  public void restoreToc(String baseName) throws IOException {
    SrtmTileArchiveToc toc = new SrtmTileArchiveToc();
    ArchiveNamer archiveNamer = new ArchiveNamer(baseName);
    for (int archiveNumber = 0; archiveNumber < 1000; archiveNumber++) {
      File archiveFile = archiveNamer.getArchiveFile((short) archiveNumber);
      if (!archiveFile.exists()) break;
      readIntoToc(toc, archiveFile, (short) archiveNumber);
    }
    SrtmTileArchiveTocRepository repository = new SrtmTileArchiveTocRepository();
    repository.write(toc, new ArchiveNamer(baseName).getTocFile());
  }

  private void readIntoToc(SrtmTileArchiveToc toc, File archiveFile, short archiveNumber) throws IOException {
    readTilesFromArchive(archiveFile, archiveNumber).stream()
        .map(this::readMetaDataAndEnrichGeoInfo)
        .forEach(tile -> toc.put(tile.name, tile));
  }

  private List<SrtmTile> readTilesFromArchive(File archiveFile, short archiveNumber) throws IOException {
    System.out.println("Processing archive " + archiveFile.getName() + "...");
    List<SrtmTile> tiles = new ArrayList<>();
    try (TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(archiveFile));) {
      for (TarArchiveEntry entry; (entry = tais.getNextTarEntry()) != null; ) {
        String name = entry.getName().replace(".hgt", "");
        SrtmTile tile = new SrtmTile();
        tile.name = name;
        tile.archiveNumber = archiveNumber;
        tiles.add(tile);
      }
    }
    return tiles;
  }

  private SrtmTile readMetaDataAndEnrichGeoInfo(SrtmTile tile) {
    GranuleMetaDataFileReader granuleMetaDataFileReader = new GranuleMetaDataFileReader();
    File metaDataFile = new File(BASE_PATH_FOR_SRTM_DATA, tile.name + ".SRTMGL3.hgt.zip.xml");
    try {
      if (!metaDataFile.exists()) {
        download(metaDataFile);
      }
      GranuleMetaDataFile granuleMetaDataFile = granuleMetaDataFileReader.read(new FileInputStream(metaDataFile));
      tile.boundingBox = map(granuleMetaDataFile.getGranuleURMetaData().getSpatialDomainContainer().getHorizontalSpatialDomainContainer().getBoundingRectangle());
    } catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
      throw new RuntimeException(e);
    }

    return tile;
  }

  private void download(File metaDataFile) throws IOException {
    String fname = metaDataFile.getName();
    System.out.println("Downloading " + fname + " ...");
    HttpURLConnection connection = (HttpURLConnection) new URL("http://e4ftl01.cr.usgs.gov/SRTM/SRTMGL3.003/2000.02.11/" + fname).openConnection();
    connection.connect();
    InputStream inputStream = connection.getInputStream();
    Files.copy(inputStream, metaDataFile.toPath());
    connection.disconnect();
  }

  private BoundingBox map(GranuleMetaDataFile.GranuleURMetaData.SpatialDomainContainer.HorizontalSpatialDomainContainer.BoundingRectangle boundingRectangle) {
    return new BoundingBox(
        boundingRectangle.getNorthBoundingCoordinate().doubleValue(),
        boundingRectangle.getEastBoundingCoordinate().doubleValue(),
        boundingRectangle.getSouthBoundingCoordinate().doubleValue(),
        boundingRectangle.getWestBoundingCoordinate().doubleValue()
    );
  }
}
