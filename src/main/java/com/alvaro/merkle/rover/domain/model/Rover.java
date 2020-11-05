package com.alvaro.merkle.rover.domain.model;

import reactor.core.publisher.Mono;

public interface Rover {

    Mono<MovementResult> moveForward();

    Mono<MovementResult> moveBackward();

    Mono<MovementResult> rotateRight();

    Mono<MovementResult> rotateLeft();
}
