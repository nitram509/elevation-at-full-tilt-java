package de.bitkings.nitram509.elevation;

import com.google.inject.Binder;
import com.google.inject.Module;
import de.bitkings.nitram509.elevation.service.ElevationService;
import de.bitkings.nitram509.elevation.service.SrtmElevationService;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

public class ElevationServerApplication {

  public static void main(String... args) throws Exception {
    RatpackServer.start(server -> server
        .registry(Guice.registry(b -> {
          b.module(new ElevationServerApplicationConfigModule());
        }))
        .handlers(chain -> chain
            .prefix("elevation", (elevationChain) -> elevationChain
                .all(ElevationHttpHandler.class)
            )
        )
    );
  }

  static class ElevationServerApplicationConfigModule implements Module {

    @Override
    public void configure(Binder binder) {
      binder.bind(ElevationHttpHandler.class);
      binder.bind(ElevationService.class).to(SrtmElevationService.class);
    }
  }
}
