package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.Grid;
import com.alvaro.merkle.rover.domain.model.GridLimits;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.GridOrientation;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class ExecuteInstructionsTest {

    private RoverCommandFactory commandFactory;
    private ExecuteInstructions executeInstructions;
    private Grid grid = new Grid(new GridLimits(5, 5));

    @BeforeEach
    public void setUp() {
        commandFactory = new RoverCommandFactory(RoverInstructionSet.getInstructionSet());
        executeInstructions = new ExecuteInstructions(commandFactory);
    }

    @Test
    public void justOneInstruction() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'f'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new RoverLocation(3, 4, GridOrientation.N))
                .verifyComplete();
    }

    @Test
    public void severalInstructions() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'b', 'r', 'f', 'l', 'l'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new RoverLocation(3, 2, GridOrientation.N))
                .expectNext(new RoverLocation(3, 2, GridOrientation.E))
                .expectNext(new RoverLocation(4, 2, GridOrientation.E))
                .expectNext(new RoverLocation(4, 2, GridOrientation.N))
                .expectNext(new RoverLocation(4, 2, GridOrientation.W))
                .verifyComplete();
    }

    @Test
    public void severalInstructionsWithWarping() {
        var start = new RoverLocation(3, 3, GridOrientation.N);
        var instructions = new Character[] {'f', 'r', 'f', 'f', 'f'};

        var locationsFlux = executeInstructions.execute(grid, start, instructions);

        StepVerifier.create(locationsFlux)
                .expectNext(new RoverLocation(3, 4, GridOrientation.N))
                .expectNext(new RoverLocation(3, 4, GridOrientation.E))
                .expectNext(new RoverLocation(4, 4, GridOrientation.E))
                .expectNext(new RoverLocation(0, 4, GridOrientation.E))
                .expectNext(new RoverLocation(1, 4, GridOrientation.E))
                .verifyComplete();
    }
}
