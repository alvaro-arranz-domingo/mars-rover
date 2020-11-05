package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.Rover;
import reactor.core.publisher.Mono;

public class RoverMovementCommand implements RoverCommand {

    private boolean isForward;

    public RoverMovementCommand(boolean isForward) {
        this.isForward = isForward;
    }

    @Override
    public Mono<MovementResult> execute(Rover rover) {
        if (isForward)
            return rover.moveForward();
        else
            return rover.moveBackward();
    }
}
