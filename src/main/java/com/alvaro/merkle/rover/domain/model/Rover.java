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
        moveForward(1);
    }

    public void moveBackwards() {
        moveForward(-1);
    }

    private void moveForward(int direction) {

        switch (location.getOrientation()) {
            case N:
                location = new GridLocation(location.getX(), location.getY() + direction, location.getOrientation());
                break;
            case S:
                location = new GridLocation(location.getX(), location.getY() - direction, location.getOrientation());
                break;
            case E:
                location = new GridLocation(location.getX() + direction, location.getY(), location.getOrientation());
                break;
            case W:
                location = new GridLocation(location.getX() - direction, location.getY(), location.getOrientation());
                break;
        }

        if (!grid.isInsideLimits(location))
            location = grid.wrapLocation(location);
    }

    private void checkGridLimits(GridDefinition grid, GridLocation location) {

        if (!grid.isInsideLimits(location))
            throw new IllegalArgumentException("Rover location is out of bounds: " + location.toString() + ", " + grid.toString());
    }

    public void rotateRight() {
        switch (location.getOrientation()) {
            case N:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.E);
                break;
            case S:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.W);
                break;
            case E:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.S);
                break;
            case W:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.N);
                break;
        }
    }
}
