package com.alvaro.merkle.rover.domain.model.factories;

import com.alvaro.merkle.rover.domain.model.Rover;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.RoverSimulated;
import com.alvaro.merkle.rover.domain.model.factories.RoverFactory;
import com.alvaro.merkle.rover.domain.model.grid.Grid;

public class RoverSimulatedFactory implements RoverFactory {

    @Override
    public Rover createRover(Grid grid, RoverLocation location) {
        return new RoverSimulated(grid, location);
    }
}
