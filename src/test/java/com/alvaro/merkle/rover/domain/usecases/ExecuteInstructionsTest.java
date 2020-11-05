package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.*;
import com.alvaro.merkle.rover.domain.model.grid.*;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.HashSet;

public class ExecuteInstructionsTest {

    private RoverCommandFactory commandFactory;
    private ExecuteInstructions executeInstructions;
    private final Grid grid = new Grid(new GridLimits(5, 5));
    private Grid gridWithObstacles;

    @BeforeEach
    public void setUp() {
        commandFactory = new RoverCommandFactory(RoverInstructionSet.getInstructionSet());
        executeInstructions = new ExecuteInstructions(commandFactory);

        var obstacles = new HashSet<Obstacle>();
        obstacles.add(new Obstacle(new GridLocation(2, 2)));
        obstacles.add(new Obstacle(new GridLocation(4, 2)));

        gridWithObstacles = new Grid(new GridLimits(5, 5), obstacles);
    }

    @Test
    public void justOneInstruction() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'f'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new MovementResult(true, new RoverLocation(3, 4, GridOrientation.N)))
                .verifyComplete();
    }

    @Test
    public void severalInstructions() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'b', 'r', 'f', 'l', 'l'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new MovementResult(true, new RoverLocation(3, 2, GridOrientation.N)))
                .expectNext(new MovementResult(true, new RoverLocation(3, 2, GridOrientation.E)))
                .expectNext(new MovementResult(true, new RoverLocation(4, 2, GridOrientation.E)))
                .expectNext(new MovementResult(true, new RoverLocation(4, 2, GridOrientation.N)))
                .expectNext(new MovementResult(true, new RoverLocation(4, 2, GridOrientation.W)))
                .verifyComplete();
    }

    @Test
    public void severalInstructionsWithWarping() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'f', 'r', 'f', 'f', 'f'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new MovementResult(true, new RoverLocation(3, 4, GridOrientation.N)))
                .expectNext(new MovementResult(true, new RoverLocation(3, 4, GridOrientation.E)))
                .expectNext(new MovementResult(true, new RoverLocation(4, 4, GridOrientation.E)))
                .expectNext(new MovementResult(true, new RoverLocation(0, 4, GridOrientation.E)))
                .expectNext(new MovementResult(true, new RoverLocation(1, 4, GridOrientation.E)))
                .verifyComplete();
    }

    @Test
    public void severalInstructionsWithObstacles() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'b', 'r', 'f', 'l', 'l'};

        var locationsFlux = executeInstructions.execute(gridWithObstacles, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new MovementResult(true, new RoverLocation(3, 2, GridOrientation.N)))
                .expectNext(new MovementResult(true, new RoverLocation(3, 2, GridOrientation.E)))
                .expectNext(new MovementResult(false, new RoverLocation(3, 2, GridOrientation.E)))
                .verifyComplete();
    }
}
