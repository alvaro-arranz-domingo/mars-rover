package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverMovementCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverRotationCommand;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverRotationTest {

    private final GridLimits grid = new GridLimits(5, 5);
    private final RoverCommand rotateRightCommand = new RoverRotationCommand(true);
    private final RoverCommand rotateLeftCommand = new RoverRotationCommand(false);

    @Test
    public void rotateRight_N() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        StepVerifier.create(rotateRightCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.E)))
                .verifyComplete();
    }

    @Test
    public void rotateRight_E() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        StepVerifier.create(rotateRightCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.S)))
                .verifyComplete();
    }

    @Test
    public void rotateRight_S() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.S));

        StepVerifier.create(rotateRightCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.W)))
                .verifyComplete();
    }

    @Test
    public void rotateRight_W() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.W));

        StepVerifier.create(rotateRightCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void rotateLeft_N() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        StepVerifier.create(rotateLeftCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.W)))
                .verifyComplete();
    }

    @Test
    public void rotateLeft_E() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        StepVerifier.create(rotateLeftCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void rotateLeft_S() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.S));

        StepVerifier.create(rotateLeftCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.E)))
                .verifyComplete();
    }

    @Test
    public void rotateLeft_W() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.W));

        StepVerifier.create(rotateLeftCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 0, GridOrientation.S)))
                .verifyComplete();
    }

}
