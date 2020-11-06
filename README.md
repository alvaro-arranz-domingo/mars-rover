# Mars Rover Challenge

The challenge has been implemented using springboot and webflux with Netty web server.
A non-blocking approach has been taken in order to communicate with the rover.
To simulate that the rover takes its time to make its movements, a delay has been introduced after each instruction.
This has been implemented in the class RoverSimulatedWithDelays.
The application doesn't block while the rover is moving or turning.
When an instruction is finished, the results are sent to the client.
Notice that only reactive clients take advantage of this characteristic. 
A common http 1.1 client will wait until all the responses are sent and the Flux has completed.

One endpoint has been implemented in order to send the instructions to the rover.

To start the server:

mvn spring-boot:run

To send instructions:

POST http://localhost:8080/rover/instructions/

```json
{
    "grid": {
        "limits": {
            "height": 5,
            "width": 5
        },
        "obstacles": []
    },
    "startLocation": {
        "x": 2,
        "y": 2,
        "orientation": "N"
    },
    "instructions": "ff"
}
```

Instructions with a grid with obstacles:

```json
{
    "grid": {
        "limits": {
            "height": 5,
            "width": 5
        },
        "obstacles": [
            { "location": { "x": 3, "y": 3 } },
            { "location": { "x": 4, "y": 4 } }
        ]
    },
    "startLocation": {
        "x": 2,
        "y": 2,
        "orientation": "N"
    },
    "instructions": "ffrffll"
}

```

