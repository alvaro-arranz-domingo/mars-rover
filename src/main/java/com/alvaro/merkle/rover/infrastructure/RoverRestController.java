package com.alvaro.merkle.rover.infrastructure;

import com.alvaro.merkle.rover.domain.model.MovementResult;
import com.alvaro.merkle.rover.domain.usecases.ExecuteInstructions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rover/instructions")
public class RoverRestController {

    private ExecuteInstructions instructions;

    public RoverRestController(ExecuteInstructions instructions) {
        this.instructions = instructions;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    private Flux<MovementResult> executeInstructions(@RequestBody InstructionsDTO instructionsDTO) {
        return instructions.execute(
                instructionsDTO.grid,
                instructionsDTO.startLocation,
                instructionsDTO.instructions.chars().mapToObj(c -> (char)c).toArray(Character[]::new));
    }
}
