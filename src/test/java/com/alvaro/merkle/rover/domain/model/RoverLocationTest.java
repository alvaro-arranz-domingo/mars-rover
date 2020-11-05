package com.alvaro.merkle.rover.domain.model;

import com.alvaro.merkle.rover.domain.model.grid.GridOrientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverLocationTest {

   @Test
   public void creation() {

        var location = new RoverLocation(3, 4, GridOrientation.N);

        assertEquals(3, location.getX());
        assertEquals(4, location.getY());
        assertEquals(GridOrientation.N, location.getOrientation());
   }
}
