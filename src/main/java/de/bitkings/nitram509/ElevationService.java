package de.bitkings.nitram509;

import java.io.IOException;

public interface ElevationService {
  int getElevation(double latitude, double longitude) throws IOException;
}
