package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

/**
 * Value object representing the limits of a Grid
 */
public class GridDefinition {

    private final int height;
    private final int width;

    public GridDefinition(int height, int width) {
        checkValidArgs(height, width);

        this.height = height;
        this.width = width;
    }

    private void checkValidArgs(int height, int width) {
        if (height <= 0)
            throw new IllegalArgumentException("The Grid cannot be defined with 0 or negative height");
        if (width <= 0)
            throw new IllegalArgumentException("The Grid cannot be defined with 0 or negative width");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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
}
