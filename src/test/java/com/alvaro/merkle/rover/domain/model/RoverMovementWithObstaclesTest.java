package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverMovementCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverMovementWithObstaclesTest {

    private Grid grid;
    private final RoverCommand moveForwardCommand = new RoverMovementCommand(true);
    private final RoverCommand moveBackwardCommand = new RoverMovementCommand(false);

    @BeforeEach
    public void setUp() {
        var obstacles = new HashSet<Obstacle>();
        obstacles.add(new Obstacle(new GridLocation(2, 2)));
        obstacles.add(new Obstacle(new GridLocation(0, 1)));

        grid = new Grid(new GridLimits(5, 5), obstacles);
    }

    @Test
    public void moveForwardToObstacle() {
        var roverLocation = new RoverLocation(2, 1, GridOrientation.N);
        var rover = new Rover(grid, roverLocation);

        StepVerifier.create(moveForwardCommand.execute(rover))
                .expectNext(new MovementResult(false, roverLocation))
                .verifyComplete();
    }

    @Test
    public void moveBackwardToObstacle() {
        var roverLocation = new RoverLocation(1, 1, GridOrientation.E);
        var rover = new Rover(grid, roverLocation);

        StepVerifier.create(moveBackwardCommand.execute(rover))
                .expectNext(new MovementResult(false, roverLocation))
                .verifyComplete();
    }

    @Test
    public void roverStartPointInObstacle() {
        var roverLocation = new RoverLocation(2, 2, GridOrientation.N);

        assertThrows(IllegalArgumentException.class, () -> new Rover(grid, roverLocation));
    }
}
