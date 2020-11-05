package com.alvaro.merkle.rover.domain.model.grid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grid {

    private final GridLimits limits;
    private final Set<Obstacle> obstacles;

    public Grid(GridLimits limits, ArrayList<Obstacle> obstacles) {
        this.limits = limits;
        this.obstacles = new HashSet<>(obstacles);
    }

    public GridLimits getLimits() {
        return limits;
    }

    public boolean containsObstacleIn(GridLocation location) {
        return obstacles.contains(new Obstacle(location));
    }
}
