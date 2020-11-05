package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.RoverSimulated;
import com.alvaro.merkle.rover.domain.model.RoverSimulatedWithDelays;
import com.alvaro.merkle.rover.domain.model.grid.Grid;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import reactor.core.publisher.Flux;

public class ExecuteInstructions {

    private RoverCommandFactory commandFactory;

    public ExecuteInstructions(RoverCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public Flux<MovementResult> execute(Grid grid, RoverLocation startLocation, Character[] instructions) {

        var roverSimulated = new RoverSimulated(grid, startLocation);
        var rover = new RoverSimulatedWithDelays(roverSimulated, 3);

        return Flux.fromArray(instructions)
                .map(i -> commandFactory.create(i))
                .flatMapSequential(c -> c.execute(rover), 1)
                .takeUntil(r -> !r.isSuccess());
    }
}
