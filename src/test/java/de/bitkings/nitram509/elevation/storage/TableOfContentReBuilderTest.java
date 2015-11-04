package de.bitkings.nitram509.elevation.storage;

import org.testng.annotations.Test;

public class TableOfContentReBuilderTest {

  @Test(enabled = false) // intended for manual index rebuilding
  public void buil_a_new_TOC_from_existing_archives() throws Exception {
    TableOfContentReBuilder reBuilder = new TableOfContentReBuilder();
    reBuilder.restoreToc("test");
  }
}