package com.alvaro.merkle.rover.domain.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GridObstacles {

    private final Set<GridLocation> obstacles;

    public GridObstacles(Collection<GridLocation> obstacles) {
        this.obstacles = new HashSet<>(obstacles);
    }

    public boolean containsObstacle(GridLocation location) {
        return obstacles.contains(location);
    }
}
