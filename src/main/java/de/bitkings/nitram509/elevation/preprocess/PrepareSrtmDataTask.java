package de.bitkings.nitram509.elevation.preprocess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import org.apache.commons.cli.*;
import ratpack.config.ConfigData;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class PrepareSrtmDataTask {

  private TaskConfig taskConfig;

  public static void main(String[] args) {
    try {
      PrepareSrtmDataTask task = new PrepareSrtmDataTask();
      task.readConfiguration();
      task.download();
      task.runTask(args);
    } catch (ParseException exp) {
      System.err.println("Parsing failed.  Reason: " + exp.getMessage());
      System.exit(1);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
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
    options.addOption("t", false, "display current time");
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);
    if (cmd.hasOption("t")) {
      System.out.println("test");
    } else {
      // automatically generate the help statement
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp(PrepareSrtmDataTask.class.getName(), options);
    }
  }
}
