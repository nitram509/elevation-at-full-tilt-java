package de.bitkings.nitram509;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface ElevationService {
  int getElevation(double latitude, double longitude) throws IOException, NoSuchAlgorithmException;
}
