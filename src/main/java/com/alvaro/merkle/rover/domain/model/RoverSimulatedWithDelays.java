package com.alvaro.merkle.rover.domain.model;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class RoverSimulatedWithDelays implements Rover {

    private RoverSimulated rover;
    private long delaySeconds;

    public RoverSimulatedWithDelays(RoverSimulated rover, long delaySeconds) {
        this.rover = rover;
        this.delaySeconds = delaySeconds;
    }

    @Override
    public Mono<MovementResult> moveForward() {
        return rover.moveForward()
                .delayElement(Duration.ofSeconds(delaySeconds));
    }

    @Override
    public Mono<MovementResult> moveBackward() {
        return rover.moveBackward()
                .delayElement(Duration.ofSeconds(delaySeconds));
    }

    @Override
    public Mono<MovementResult> rotateRight() {
        return rover.rotateRight()
                .delayElement(Duration.ofSeconds(delaySeconds));
    }

    @Override
    public Mono<MovementResult> rotateLeft() {
        return rover.rotateLeft()
                .delayElement(Duration.ofSeconds(delaySeconds));
    }
}
