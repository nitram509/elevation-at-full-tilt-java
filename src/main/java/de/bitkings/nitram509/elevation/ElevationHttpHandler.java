package de.bitkings.nitram509.elevation;

import de.bitkings.nitram509.elevation.service.ElevationService;
import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.util.MultiValueMap;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import static java.lang.Double.parseDouble;

@Singleton
@Named
public class ElevationHttpHandler implements Handler {

  @Inject
  ElevationService elevationService;

  @Override
  public void handle(Context ctx) throws Exception {
    MultiValueMap<String, String> queryParams = ctx.getRequest().getQueryParams();
    if (queryParams.containsKey("lat") && queryParams.containsKey("lon")) {
      double lat = parseDouble(queryParams.get("lat"));
      double lon = parseDouble(queryParams.get("lon"));
      Blocking
          .get(() -> elevationService.getElevation(lat, lon))
          .then(height -> {
            ctx.getResponse()
                .contentType("application/json")
                .status(Status.OK)
                .send(createElevationJson(lat, lon, height).getBytes("ASCII"));
          });
    } else {
      ctx.getResponse()
          .status(Status.of(400))
          .send();
    }
  }

  private String createElevationJson(double lat, double lon, int height) {
    return "{" +
        "\"elevation\":" + height + "," +
        "\"location\":{" +
        "\"lat\":" + lat + "," +
        "\"lon\":" + lon +
        "}}";
  }
}
