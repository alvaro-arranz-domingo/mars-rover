package com.alvaro.merkle.rover.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMovementTest {

    private final GridLimits grid = new GridLimits(5, 5);

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
    public void moveForwardEdgeWrapping() {
        var rover = new Rover(grid, new GridLocation(4,4, GridOrientation.N));

        rover.moveForward();

        assertEquals(new GridLocation(4, 0, GridOrientation.N), rover.getCurrentLocation());
    }

    @Test
    public void moveBackwards_N() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.N));

        rover.moveBackwards();

        assertEquals(new GridLocation(2, 1, GridOrientation.N), rover.getCurrentLocation());
    }

    @Test
    public void moveBackwards_E() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.E));

        rover.moveBackwards();

        assertEquals(new GridLocation(1, 2, GridOrientation.E), rover.getCurrentLocation());
    }

    @Test
    public void moveBackwards_S() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.S));

        rover.moveBackwards();

        assertEquals(new GridLocation(2, 3, GridOrientation.S), rover.getCurrentLocation());
    }

    @Test
    public void moveBackwards_W() {
        var rover = new Rover(grid, new GridLocation(2,2, GridOrientation.W));

        rover.moveBackwards();

        assertEquals(new GridLocation(3, 2, GridOrientation.W), rover.getCurrentLocation());
    }

    @Test
    public void moveBackwardsEdgeWrapping() {
        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        rover.moveBackwards();

        assertEquals(new GridLocation(0, 4, GridOrientation.N), rover.getCurrentLocation());
    }
}
