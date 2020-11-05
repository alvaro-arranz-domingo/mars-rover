package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.model.grid.Grid;
import com.alvaro.merkle.rover.domain.model.grid.GridLimits;
import com.alvaro.merkle.rover.domain.model.grid.GridOrientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverSimulatedTest {

    private final Grid grid = new Grid(new GridLimits(5, 5));

    @Test
    public void roverInitialization() {
        var location = new RoverLocation(0,0, GridOrientation.N);

        var rover = new RoverSimulated(grid, location);

        assertEquals(grid, rover.getGrid());
        assertEquals(location, rover.getCurrentLocation());
    }

    @Test
    public void roverInitializationOutsideGridX() {
        var location = new RoverLocation(grid.getLimits().getWidth() + 1,0, GridOrientation.N);

        assertThrows(IllegalArgumentException.class, () -> new RoverSimulated(grid, location));
    }

    @Test
    public void roverInitializationOutsideGridY() {
        var location = new RoverLocation(0,grid.getLimits().getHeight() + 1, GridOrientation.N);

        assertThrows(IllegalArgumentException.class, () -> new RoverSimulated(grid, location));
    }
}
