package com.alvaro.merkle.rover.domain.model;

public class Rover {

    private final GridDefinition grid;
    private GridLocation location;

    public Rover(GridDefinition grid, GridLocation location) {

        checkGridLimits(grid, location);

        this.grid = grid;
        this.location = location;
    }

    public GridLocation getCurrentLocation() { return location; }

    public GridDefinition getGridDefinition() { return grid; }

    public void moveForward() {

        switch (location.getOrientation()) {
            case N:
                location = new GridLocation(location.getX(), location.getY() + 1, location.getOrientation());
                break;
            case S:
                location = new GridLocation(location.getX(), location.getY() - 1, location.getOrientation());
                break;
            case E:
                location = new GridLocation(location.getX() + 1, location.getY(), location.getOrientation());
                break;
            case W:
                location = new GridLocation(location.getX() - 1, location.getY(), location.getOrientation());
                break;
        }

        fixEdgeWrapping();
    }

    private void checkGridLimits(GridDefinition grid, GridLocation location) {
        if (location.getX() >= grid.getWidth())
            throw new IllegalArgumentException("Rover X coordinate is out of bounds: " + location.toString() + ", " + grid.toString());
        if (location.getY() >= grid.getHeight())
            throw new IllegalArgumentException("Rover Y coordinate is out of bounds: " + location.toString() + ", " + grid.toString());
    }

    private void fixEdgeWrapping() {
        if (location.getX() == grid.getWidth())
            location = new GridLocation(0, location.getY(), location.getOrientation());
        else if (location.getX() < 0)
            location = new GridLocation(grid.getWidth() - 1, location.getY(), location.getOrientation());
        else if (location.getY() == grid.getHeight())
            location = new GridLocation(location.getX(), 0, location.getOrientation());
        else if (location.getY() < 0)
            location = new GridLocation(location.getY(), grid.getHeight() - 1, location.getOrientation());
    }
}
