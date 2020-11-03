package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.Rover;

public class RoverRotationCommand implements RoverCommand {

    private final boolean isRight;

    public RoverRotationCommand(boolean isRight) {
        this.isRight = isRight;
    }

    @Override
    public void execute(Rover rover) {
        if (isRight)
            rover.rotateRight();
        else
            rover.rotateLeft();
    }
}
