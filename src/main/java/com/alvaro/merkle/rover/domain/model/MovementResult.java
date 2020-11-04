package com.alvaro.merkle.rover.domain.model;

import java.util.Objects;

public class MovementResult {

    private final boolean isSuccess;
    private final GridLocation location;

    public MovementResult(boolean isSuccess, GridLocation location) {
        this.isSuccess = isSuccess;
        this.location = location;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public GridLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "MovementResult{" +
                "isSuccess=" + isSuccess +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovementResult that = (MovementResult) o;
        return isSuccess == that.isSuccess &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSuccess, location);
    }
}
