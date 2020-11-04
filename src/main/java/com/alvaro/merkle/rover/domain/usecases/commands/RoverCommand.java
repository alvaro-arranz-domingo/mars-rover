package com.alvaro.merkle.rover.domain.usecases.commands;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.model.Rover;
import reactor.core.publisher.Mono;

public interface RoverCommand {

    Mono<MovementResult> execute(Rover rover);
}
