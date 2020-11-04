package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

public class Obstacle {

    private final GridLocation location;

    public Obstacle(GridLocation location) {
        this.location = location;
    }

    public GridLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return Objects.equals(location, obstacle.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
