package de.bitkings.nitram509.elevation

import groovy.json.JsonSlurper
import ratpack.test.MainClassApplicationUnderTest
import ratpack.test.ServerBackedApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Specification

class ElevationHttpHandlerSpec extends Specification{

    ServerBackedApplicationUnderTest esa = new MainClassApplicationUnderTest(ElevationServerApplication.class)
    @Delegate TestHttpClient client = testHttpClient(esa)

    def "Golden Test data can be retrieved"() {

        when:
        client.get("/elevation?lat=50.4163577778&lon=14.9198269444")

        then:
        assert response.statusCode == 200
        def elevationResponse = new JsonSlurper().parseText(response.body.text)
        assert elevationResponse.elevation == 216
        assert elevationResponse.location.lat == 50.4163577778
        assert elevationResponse.location.lon == 14.9198269444
    }

    def cleanup() {
        esa.stop()
    }

}