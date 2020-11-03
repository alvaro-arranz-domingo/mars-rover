package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.GridLocation;
import com.alvaro.merkle.rover.domain.model.Rover;

public interface RoverCommand {

    void execute(Rover rover);
}
