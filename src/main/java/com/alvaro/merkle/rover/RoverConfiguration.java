package com.alvaro.merkle.rover;

import com.alvaro.merkle.rover.domain.usecases.ExecuteInstructions;
import com.alvaro.merkle.rover.domain.usecases.RoverInstructionSet;
import com.alvaro.merkle.rover.domain.usecases.commands.RoverCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoverConfiguration {

    @Bean
    public RoverCommandFactory commandFactory() {
        return new RoverCommandFactory(RoverInstructionSet.getInstructionSet());
    }

    @Bean
    public ExecuteInstructions executor(RoverCommandFactory commandFactory) {
        return new ExecuteInstructions(commandFactory);
    }
}
