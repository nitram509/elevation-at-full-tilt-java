package de.bitkings.nitram509.elevation.storage;

import org.testng.annotations.Test;

public class TableOfContentReBuilderTest {

  @Test(enabled = false) // intended for manual index rebuilding
  public void testName() throws Exception {
    TableOfContentReBuilder reBuilder = new TableOfContentReBuilder();
    reBuilder.restoreToc("test");
  }
}