package com.alvaro.merkle.rover.domain.model.factories;

import com.alvaro.merkle.rover.domain.model.Rover;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.RoverSimulated;
import com.alvaro.merkle.rover.domain.model.RoverSimulatedWithDelays;
import com.alvaro.merkle.rover.domain.model.factories.RoverFactory;
import com.alvaro.merkle.rover.domain.model.grid.Grid;

public class RoverSimulatedWithDelaysFactory implements RoverFactory {

    private long delaySeconds;

    public RoverSimulatedWithDelaysFactory(long delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

    @Override
    public Rover createRover(Grid grid, RoverLocation location) {
        return new RoverSimulatedWithDelays(new RoverSimulated(grid, location), delaySeconds);
    }
}
