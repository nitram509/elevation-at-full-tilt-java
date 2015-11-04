package de.bitkings.nitram509.elevation.preprocess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTile;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveToc;
import de.bitkings.nitram509.elevation.preprocess.srtm.SrtmTileArchiveTocRepository;
import de.bitkings.nitram509.elevation.storage.ArchiveNamer;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import org.apache.commons.cli.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.config.ConfigData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class PrepareSrtmDataTask {
  private final static Logger LOG = LoggerFactory.getLogger(PrepareSrtmDataTask.class);

  private TaskConfig taskConfig;
  private final LZ4Factory factory;

  public PrepareSrtmDataTask() {
    this.factory = LZ4Factory.fastestInstance();
  }

  public static void main(String[] args) {
    try {
      PrepareSrtmDataTask task = new PrepareSrtmDataTask();
      task.readConfiguration();
      task.runTask(args);
      task.loadAllTilesAndSplitThem();
    } catch (ParseException exp) {
      System.err.println("Parsing failed.  Reason: " + exp.getMessage());
      System.exit(1);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  private void loadAllTilesAndSplitThem() throws IOException {
    ArchiveNamer archiveNamer = new ArchiveNamer("test");
    SrtmTileArchiveToc toc = new SrtmTileArchiveTocRepository().read(archiveNamer.getTocFile());
    for (SrtmTile tile : toc.getAll()) {
      byte[] srtmData = loadSrtmData(archiveNamer.getArchiveFile(tile.archiveNumber), tile.name);
      new SrtmTileSplitter(tile, srtmData);
    }
  }

  private byte[] loadSrtmData(File tarFile, String tileName) throws IOException {
    try (TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(tarFile))) {
      for (TarArchiveEntry tae; (tae = tais.getNextTarEntry()) != null; ) {
        if (!tae.getName().startsWith(tileName)) continue;
        byte[] buf = new byte[(int) tae.getSize()];
        int read = tais.read(buf, 0, (int) tae.getSize());
        if (read != tae.getSize()) {
          LOG.warn(String.format("Couldn't read all data from archive. tarFile:%s, fileName:%s", tarFile, tae.getName()));
        }
        return decompress(buf);
      }
    }
    throw new IllegalStateException("can't find tile:" + tileName + " in archive: " + tarFile);
  }

  private byte[] decompress(byte[] buf) {
    LZ4FastDecompressor decompressor = factory.fastDecompressor();
    byte[] uncompressed = new byte[2_884_802];
    decompressor.decompress(buf, uncompressed);
    return uncompressed;
  }

  private void download() throws ExecutionException, InterruptedException {
    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    Future<Response> f = asyncHttpClient.prepareGet("http://www.ning.com/").execute();
    Response r = f.get();
    System.out.println(r);
  }

  private void readConfiguration() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerSubtypes(TaskConfig.class);
    ConfigData configData = ConfigData.builder(objectMapper)
        .yaml(new File("application.yaml").toPath())
        .env()
        .sysProps()
        .build();
    taskConfig = configData.get(TaskConfig.class);
  }

  private void runTask(String[] args) throws Exception {
    Options options = new Options();
    options.addOption("h", "help", false, "show help");
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);
    if (cmd.hasOption("h") || cmd.hasOption("help")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp(PrepareSrtmDataTask.class.getName(), options);
      System.exit(0);
    }
  }
}
