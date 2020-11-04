package com.alvaro.merkle.rover.domain.model;

import reactor.core.publisher.Mono;

public class Rover {

    private final GridLimits grid;
    private GridLocation location;

    public Rover(GridLimits grid, GridLocation location) {

        checkGridLimits(grid, location);

        this.grid = grid;
        this.location = location;
    }

    public GridLocation getCurrentLocation() { return location; }

    public GridLimits getGridDefinition() { return grid; }

    public Mono<MovementResult> moveForward() {
        return moveForward(1);
    }

    public Mono<MovementResult> moveBackwards() {
        return moveForward(-1);
    }

    private Mono<MovementResult> moveForward(int direction) {
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

        return Mono.just(new MovementResult(true, location));
    }

    public Mono<MovementResult> rotateRight() {
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

        return Mono.just(new MovementResult(true, location));
    }

    public Mono<MovementResult> rotateLeft() {
        switch (location.getOrientation()) {
            case N:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.W);
                break;
            case S:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.E);
                break;
            case E:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.N);
                break;
            case W:
                location = new GridLocation(location.getX(), location.getY(), GridOrientation.S);
                break;
        }

        return Mono.just(new MovementResult(true, location));
    }

    private void checkGridLimits(GridLimits grid, GridLocation location) {

        if (!grid.isInsideLimits(location))
            throw new IllegalArgumentException("Rover location is out of bounds: " + location.toString() + ", " + grid.toString());
    }
}
