package com.alvaro.merkle.rover.domain.usecases.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RoverCommandFactory {

    private Map<Character, Supplier<RoverCommand>> instructions;

    public RoverCommandFactory(Map<Character, Supplier<RoverCommand>> instructions) {
        this.instructions = instructions;
    }

    public RoverCommand create(char instruction) {
        var normalized = Character.toLowerCase(instruction);

        if (!instructions.containsKey(normalized))
            throw new IllegalArgumentException("La instrucción " + normalized + " no es conocida");

        return instructions.get(normalized).get();
    }
}
