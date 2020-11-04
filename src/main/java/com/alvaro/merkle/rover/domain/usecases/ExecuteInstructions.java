package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.model.Grid;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.Rover;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import reactor.core.publisher.Flux;

public class ExecuteInstructions {

    private RoverCommandFactory commandFactory;

    public ExecuteInstructions(RoverCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public Flux<RoverLocation> execute(Grid grid, RoverLocation startLocation, Character[] instructions) {

        var rover = new Rover(grid, startLocation);

        return Flux.fromArray(instructions)
                .map(i -> commandFactory.create(i))
                .map(command -> {
                    command.execute(rover);
                    return rover.getCurrentLocation();
                });
    }
}
