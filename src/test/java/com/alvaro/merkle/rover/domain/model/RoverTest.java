package com.alvaro.merkle.rover.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {

    private final GridDefinition grid = new GridDefinition(5, 5);

    @Test
    public void roverInitialization() {
        var location = new GridLocation(0,0, GridOrientation.N);

        var rover = new Rover(grid, location);

        assertEquals(grid, rover.getGridDefinition());
        assertEquals(location, rover.getCurrentLocation());
    }

    @Test
    public void roverInitializationOutsideGridX() {
        var location = new GridLocation(grid.getWidth() + 1,0, GridOrientation.N);

        assertThrows(IllegalArgumentException.class, () -> new Rover(grid, location));
    }

    @Test
    public void roverInitializationOutsideGridY() {
        var location = new GridLocation(0,grid.getHeight() + 1, GridOrientation.N);

        assertThrows(IllegalArgumentException.class, () -> new Rover(grid, location));
    }
}
