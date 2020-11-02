package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

/**
 * Value object representing the location and orientation in a grid
 */
public class GridLocation {

    private final int x;
    private final int y;
    private final GridOrientation orientation;

    public GridLocation(int x, int y, GridOrientation orientation) {
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

    public GridOrientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "GridLocation{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridLocation that = (GridLocation) o;
        return x == that.x &&
                y == that.y &&
                orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }
}
