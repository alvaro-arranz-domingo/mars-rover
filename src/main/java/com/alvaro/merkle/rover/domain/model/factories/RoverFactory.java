package com.alvaro.merkle.rover.domain.model.factories;

import com.alvaro.merkle.rover.domain.model.Rover;
import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.grid.Grid;

public interface RoverFactory {

    Rover createRover(Grid grid, RoverLocation location);
}
