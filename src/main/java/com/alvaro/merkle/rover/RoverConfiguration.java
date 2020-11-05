package com.alvaro.merkle.rover;

import com.alvaro.merkle.rover.domain.model.factories.RoverFactory;
import com.alvaro.merkle.rover.domain.model.factories.RoverSimulatedWithDelaysFactory;
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
    public RoverFactory roverFactory() {
        return new RoverSimulatedWithDelaysFactory(2);
    }

    @Bean
    public ExecuteInstructions executor(RoverCommandFactory commandFactory, RoverFactory roverFactory) {
        return new ExecuteInstructions(commandFactory, roverFactory);
    }
}
