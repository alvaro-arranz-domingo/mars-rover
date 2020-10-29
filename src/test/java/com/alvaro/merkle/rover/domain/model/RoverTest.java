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

    @Test
    public void moveForward_N() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        rover.moveForward();

        assertEquals(new GridLocation(0, 1, GridOrientation.N), rover.getCurrentLocation());
    }

    @Test
    public void moveForward_E() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        rover.moveForward();

        assertEquals(new GridLocation(1, 0, GridOrientation.E), rover.getCurrentLocation());
    }

    @Test
    public void moveForward_S() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.S));

        rover.moveForward();

        assertEquals(new GridLocation(2, 1, GridOrientation.S), rover.getCurrentLocation());
    }

    @Test
    public void moveForward_W() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.W));

        rover.moveForward();

        assertEquals(new GridLocation(1, 2, GridOrientation.W), rover.getCurrentLocation());
    }

    @Test
    public void moveForwrdEdgeWrapping() {
        var rover = new Rover(grid, new GridLocation(4,4, GridOrientation.N));

        rover.moveForward();

        assertEquals(new GridLocation(4, 0, GridOrientation.N), rover.getCurrentLocation());
    }
}
