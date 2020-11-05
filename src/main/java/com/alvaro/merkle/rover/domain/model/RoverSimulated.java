package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.model.grid.Grid;
import com.alvaro.merkle.rover.domain.model.grid.GridLimits;
import com.alvaro.merkle.rover.domain.model.grid.GridOrientation;
import reactor.core.publisher.Mono;

public class RoverSimulated implements Rover {

    private final Grid grid;
    private RoverLocation location;

    public RoverSimulated(Grid grid, RoverLocation location) {

        checkGridLimits(grid.getLimits(), location);
        checkObstacle(grid, location);

        this.grid = grid;
        this.location = location;
    }

    public RoverLocation getCurrentLocation() { return location; }

    public Grid getGrid() {
        return grid;
    }

    public Mono<MovementResult> moveForward() {
        return moveForward(1);
    }

    public Mono<MovementResult> moveBackward() {
        return moveForward(-1);
    }

    public Mono<MovementResult> rotateRight() {

        switch (location.getOrientation()) {
            case N:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.E);
                break;
            case S:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.W);
                break;
            case E:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.S);
                break;
            case W:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.N);
                break;
        }

        return Mono.just(new MovementResult(true, location));
    }

    public Mono<MovementResult> rotateLeft() {

        switch (location.getOrientation()) {
            case N:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.W);
                break;
            case S:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.E);
                break;
            case E:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.N);
                break;
            case W:
                location = new RoverLocation(location.getX(), location.getY(), GridOrientation.S);
                break;
        }

        return Mono.just(new MovementResult(true, location));
    }

    private Mono<MovementResult> moveForward(int direction) {

        RoverLocation newLocation = null;

        switch (location.getOrientation()) {
            case N:
                newLocation = new RoverLocation(location.getX(), location.getY() + direction, location.getOrientation());
                break;
            case S:
                newLocation = new RoverLocation(location.getX(), location.getY() - direction, location.getOrientation());
                break;
            case E:
                newLocation = new RoverLocation(location.getX() + direction, location.getY(), location.getOrientation());
                break;
            case W:
                newLocation = new RoverLocation(location.getX() - direction, location.getY(), location.getOrientation());
                break;
        }

        if (grid.getLimits().isOutsideLimits(newLocation)) {
            newLocation = grid.getLimits().wrapLocation(newLocation);
        }

        if (grid.containsObstacleIn(newLocation.getGridLocation())) {
            return Mono.just(new MovementResult(false, location));
        }

        location = newLocation;

        return Mono.just(new MovementResult(true, location));
    }

    private void checkGridLimits(GridLimits grid, RoverLocation location) {

        if (grid.isOutsideLimits(location))
            throw new IllegalArgumentException("Rover location is out of bounds: " + location.toString() + ", " + grid.toString());
    }

    private void checkObstacle(Grid grid, RoverLocation location) {
        if (grid.containsObstacleIn(location.getGridLocation()))
            throw new IllegalArgumentException("Rover starting location cannot be in an obstacle");
    }
}
