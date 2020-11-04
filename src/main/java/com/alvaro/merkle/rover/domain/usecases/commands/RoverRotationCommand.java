package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.Rover;
import reactor.core.publisher.Mono;

public class RoverRotationCommand implements RoverCommand {

    private final boolean isRight;

    public RoverRotationCommand(boolean isRight) {
        this.isRight = isRight;
    }

    @Override
    public Mono<MovementResult> execute(Rover rover) {
        if (isRight)
            return rover.rotateRight();
        else
            return rover.rotateLeft();
    }
}
