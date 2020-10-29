package com.alvaro.merkle.rover.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GridDefinitionTest {

    @Test
    public void creation() {

        var grid = new GridDefinition(3, 5);

        assertEquals(3, grid.getHeight());
        assertEquals(5, grid.getWidth());
    }

    @Test
    public void negativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new GridDefinition(-1, 5));
    }

    @Test
    public void negativeWidth() {
        assertThrows(IllegalArgumentException.class, () -> new GridDefinition(5, -1));
    }

    @Test
    public void zeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> new GridDefinition(0, 5));
    }

    @Test
    public void zeroWidth() {
        assertThrows(IllegalArgumentException.class, () -> new GridDefinition(5, 0));
    }
}
