package com.maartenmusic.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void turnRight() {
        Ship ship = new Ship();
        assertEquals(Ship.Direction.EAST, ship.getDirection());

        ship.turnRight(45);
        assertEquals(Ship.Direction.SOUTH, ship.getDirection());

        ship.turnRight(45);
        assertEquals(Ship.Direction.WEST, ship.getDirection());

        ship.turnRight(90);
        assertEquals(Ship.Direction.EAST, ship.getDirection());
    }
}