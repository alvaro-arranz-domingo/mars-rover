package com.alvaro.merkle.rover.domain.usecases;

import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverMovementCommand;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverRotationCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RoverInstructionSet {

     static public Map<Character, Supplier<RoverCommand>> getInstructionSet() {
        Map<Character, Supplier<RoverCommand>> instructions = new HashMap<>();
        instructions.put('f', () -> new RoverMovementCommand(true));
        instructions.put('b', () -> new RoverMovementCommand(false));
        instructions.put('r', () -> new RoverRotationCommand(true));
        instructions.put('l', () -> new RoverRotationCommand(false));
        return instructions;
    }
}
