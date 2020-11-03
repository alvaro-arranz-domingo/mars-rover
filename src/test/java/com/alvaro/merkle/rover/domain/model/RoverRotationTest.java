package com.alvaro.merkle.rover.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverRotationTest {

    private final GridLimits grid = new GridLimits(5, 5);

    @Test
    public void rotateRight_N() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        rover.rotateRight();

        assertEquals(GridOrientation.E, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateRight_E() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        rover.rotateRight();

        assertEquals(GridOrientation.S, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateRight_S() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.S));

        rover.rotateRight();

        assertEquals(GridOrientation.W, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateRight_W() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.W));

        rover.rotateRight();

        assertEquals(GridOrientation.N, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateLeft_N() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.N));

        rover.rotateLeft();

        assertEquals(GridOrientation.W, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateLeft_E() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.E));

        rover.rotateLeft();

        assertEquals(GridOrientation.N, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateLeft_S() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.S));

        rover.rotateLeft();

        assertEquals(GridOrientation.E, rover.getCurrentLocation().getOrientation());
    }

    @Test
    public void rotateLeft_W() {

        var rover = new Rover(grid, new GridLocation(0,0, GridOrientation.W));

        rover.rotateLeft();

        assertEquals(GridOrientation.S, rover.getCurrentLocation().getOrientation());
    }

}
