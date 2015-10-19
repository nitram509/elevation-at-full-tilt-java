package de.bitkings.nitram509.elevation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class HeavyLoadSimulation extends Simulation {

  val EXPECTED_RESPONSE = "{\"elevation\":43,\"location\":{\"lat\":52.16667,\"lon\":13.4}}".getBytes()
  val EXPECTED_RESPONSE_STR = "{\"elevation\":43,\"location\":{\"lat\":52.16667,\"lon\":13.4}}"

  val httpConf = http
    .baseURL("http://localhost:5050")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("HeavyLoadSimulation")
    .during(30) {
      exec(http("request_elevation_for_berlin")
        .get("/elevation?lat=52.16667&lon=13.4")
        .check(
          status.is(200),
          bodyString.is(EXPECTED_RESPONSE_STR)
        )
      )
    }

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpConf)
}