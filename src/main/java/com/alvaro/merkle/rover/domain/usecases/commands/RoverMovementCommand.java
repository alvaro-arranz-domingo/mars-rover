package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.Rover;

public class RoverMovementCommand implements RoverCommand {

    private boolean isForward;

    public RoverMovementCommand(boolean isForward) {
        this.isForward = isForward;
    }

    @Override
    public void execute(Rover rover) {
        if (isForward)
            rover.moveForward();
        else
            rover.moveBackwards();
    }
}
