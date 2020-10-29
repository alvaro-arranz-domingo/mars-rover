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

   @Test
   public void zeroWidthHeightIsValid() {

       var location = new GridLocation(0, 0, GridOrientation.N);

       assertEquals(0, location.getX());
       assertEquals(0, location.getY());
   }

   @Test
   public void negativeX() {
       assertThrows(IllegalArgumentException.class, () -> new GridLocation(-1, 5, GridOrientation.N));
   }

   @Test
   public void negativeY() {
       assertThrows(IllegalArgumentException.class, () -> new GridLocation(3, -3, GridOrientation.N));
   }
}
