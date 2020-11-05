package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.model.grid.GridLocation;
import com.alvaro.merkle.rover.domain.model.grid.GridOrientation;

import java.util.Objects;

/**
 * Value object representing the location and orientation in a grid
 */
public class RoverLocation {

    private final int x;
    private final int y;
    private final GridOrientation orientation;

    public RoverLocation(int x, int y, GridOrientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GridLocation getGridLocation() {
        return new GridLocation(x, y);
    }

    public GridOrientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "RoverLocation{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverLocation that = (RoverLocation) o;
        return x == that.x &&
                y == that.y &&
                orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }
}
