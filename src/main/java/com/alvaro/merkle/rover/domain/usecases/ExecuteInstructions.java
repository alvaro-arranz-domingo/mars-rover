package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.factories.RoverFactory;
import com.alvaro.merkle.rover.domain.model.grid.Grid;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class ExecuteInstructions {

    private RoverCommandFactory commandFactory;
    private RoverFactory roverFactory;

    public ExecuteInstructions(RoverCommandFactory commandFactory, RoverFactory roverFactory) {
        this.commandFactory = commandFactory;
        this.roverFactory = roverFactory;
    }

    public Flux<MovementResult> execute(Grid grid, RoverLocation startLocation, Character[] instructions) {

        var rover = roverFactory.createRover(grid, startLocation);
        var commands = Arrays.stream(instructions).map(i -> commandFactory.create(i));

        return Flux.fromStream(commands)
                .flatMapSequential(c -> c.execute(rover), 1)
                .takeUntil(r -> !r.isSuccess());
    }
}
