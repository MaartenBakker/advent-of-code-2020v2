package com.maartenmusic.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void move() {
        Coordinates coordinates = new Coordinates();
        Coordinates moved = coordinates.move(1,1);
        assertEquals(new Coordinates(1,1), moved);
    }

    @Test
    void manhattanDistance() {
        Coordinates coordinates = new Coordinates(-5, 10);
        assertEquals(15, coordinates.manhattanDistance());
    }
}