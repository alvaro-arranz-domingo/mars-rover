package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.grid.Grid;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.RoverSimulated;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import reactor.core.publisher.Flux;

public class ExecuteInstructions {

    private RoverCommandFactory commandFactory;

    public ExecuteInstructions(RoverCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public Flux<MovementResult> execute(Grid grid, RoverLocation startLocation, Character[] instructions) {

        var rover = new RoverSimulated(grid, startLocation);

        return Flux.fromArray(instructions)
                .map(i -> commandFactory.create(i))
                .flatMap(c -> c.execute(rover))
                .takeUntil(r -> !r.isSuccess())
                .limitRate(1)
                .onErrorStop();
    }
}
