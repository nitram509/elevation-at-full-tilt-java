
# Elevation at full tilt

## Prepare the server

tbd.

## API

### GET /elevation?lat={latitudeInDegree}&lon={longitudeInDegree}

+ Response 200 (application/json)

            {
              "elevation": 216,
              "location": {
                "lat": 50.4163577778,
                "lon": 14.9198269444
              }
            }
EOF

## Build

* Requires: Java 1.8


## Run

```
./gradlew build
PORT=8080 ./gradlew run
```

