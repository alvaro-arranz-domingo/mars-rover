package com.alvaro.merkle.rover.infrastructure;

import com.alvaro.merkle.rover.domain.model.RoverLocation;
import com.alvaro.merkle.rover.domain.model.grid.Grid;

public class InstructionsDTO {

    public Grid grid;
    public RoverLocation startLocation;
    public String instructions;

    public InstructionsDTO(Grid grid, RoverLocation startLocation, String instructions) {
        this.grid = grid;
        this.startLocation = startLocation;
        this.instructions = instructions;
    }
}
