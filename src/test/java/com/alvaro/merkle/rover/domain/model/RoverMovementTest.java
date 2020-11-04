package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverMovementCommand;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMovementTest {

    private final GridLimits grid = new GridLimits(5, 5);
    private final RoverCommand moveForwardCommand = new RoverMovementCommand(true);
    private final RoverCommand moveBackwardCommand = new RoverMovementCommand(false);

    @Test
    public void moveForward_N() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 1, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void moveForward_E() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(1, 0, GridOrientation.E)))
                .verifyComplete();
    }

    @Test
    public void moveForward_S() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.S));

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(2, 1, GridOrientation.S)))
                .verifyComplete();
    }

    @Test
    public void moveForward_W() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.W));

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(1, 2, GridOrientation.W)))
                .verifyComplete();
    }

    @Test
    public void moveForwardEdgeWrapping() {
        var rover = new Rover(grid, new GridLocation(4,4, GridOrientation.N));

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(4, 0, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void moveBackwards_N() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.N));

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(2, 1, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void moveBackwards_E() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.E));

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(1, 2, GridOrientation.E)))
                .verifyComplete();
    }

    @Test
    public void moveBackwards_S() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.S));

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(2, 3, GridOrientation.S)))
                .verifyComplete();
    }

    @Test
    public void moveBackwards_W() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.W));

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(3, 2, GridOrientation.W)))
                .verifyComplete();
    }

    @Test
    public void moveBackwardsEdgeWrapping() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(true, new GridLocation(0, 4, GridOrientation.N)))
                .verifyComplete();
    }
}
