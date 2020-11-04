package com.alvaro.merkle.rover.domain.model;

public class Grid {

    private final GridLimits limits;
    private final GridObstacles obstacles;

    public Grid(GridLimits limits, GridObstacles obstacles) {
        this.limits = limits;
        this.obstacles = obstacles;
    }

    public GridLimits getLimits() {
        return limits;
    }

    public GridObstacles getObstacles() {
        return obstacles;
    }
}
