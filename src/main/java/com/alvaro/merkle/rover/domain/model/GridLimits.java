package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

/**
 * Value object representing the limits of a Grid
 */
public class GridLimits {

    private final int height;
    private final int width;

    public GridLimits(int height, int width) {
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

    public boolean isInsideLimits(RoverLocation location) {
        return location.getX() >= 0
                && location.getX() < getWidth()
                && location.getY() >= 0
                && location.getY() < getHeight();
    }

    public RoverLocation wrapLocation(RoverLocation location) {
        if (location.getX() == getWidth())
            return new RoverLocation(0, location.getY(), location.getOrientation());
        else if (location.getX() < 0)
            return new RoverLocation(getWidth() - 1, location.getY(), location.getOrientation());
        else if (location.getY() == getHeight())
            return new RoverLocation(location.getX(), 0, location.getOrientation());
        else if (location.getY() < 0)
            return new RoverLocation(location.getX(), getHeight() - 1, location.getOrientation());

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
        GridLimits that = (GridLimits) o;
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
