package de.bitkings.nitram509.elevation.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface ElevationService {
  int getElevation(double latitude, double longitude) throws IOException, NoSuchAlgorithmException;
}
