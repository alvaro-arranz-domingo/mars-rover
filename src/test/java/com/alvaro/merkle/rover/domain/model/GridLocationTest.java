package com.alvaro.merkle.rover.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GridLocationTest {

   @Test
   public void creation() {

        var location = new GridLocation(3, 4, GridOrientation.N);

        assertEquals(3, location.getX());
        assertEquals(4, location.getY());
        assertEquals(GridOrientation.N, location.getOrientation());
   }
}
