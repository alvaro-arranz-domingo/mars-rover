package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

/**
 * Value object representing the limits of a Grid
 */
public class GridDefinition {

    private final int height;
    private final int width;

    public GridDefinition(int height, int width) {
        checkArePositive(height, width);

        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isInsideLimits(GridLocation location) {
        return location.getX() >= 0
                && location.getX() < getWidth()
                && location.getY() >= 0
                && location.getY() < getHeight();
    }

    public GridLocation wrapLocation(GridLocation location) {
        if (location.getX() == getWidth())
            return new GridLocation(0, location.getY(), location.getOrientation());
        else if (location.getX() < 0)
            return new GridLocation(getWidth() - 1, location.getY(), location.getOrientation());
        else if (location.getY() == getHeight())
            return new GridLocation(location.getX(), 0, location.getOrientation());
        else if (location.getY() < 0)
            return new GridLocation(location.getX(), getHeight() - 1, location.getOrientation());

        return location;
    }

    @Override
    public String toString() {
        return "GridDefinition{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridDefinition that = (GridDefinition) o;
        return height == that.height &&
                width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    private void checkArePositive(int height, int width) {
        if (height <= 0)
            throw new IllegalArgumentException("The Grid cannot be defined with 0 or negative height");
        if (width <= 0)
            throw new IllegalArgumentException("The Grid cannot be defined with 0 or negative width");
    }
}
