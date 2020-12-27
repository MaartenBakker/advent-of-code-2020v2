package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WayPointTest {

    @Test
    void moveNorth() {
        WayPoint wayPoint = new WayPoint();
        wayPoint.moveNorth(10);
        assertEquals(new Coordinates(10, 11), wayPoint.getCoordinates());
    }

    @Test
    void moveSouth() {
        WayPoint wayPoint = new WayPoint();
        wayPoint.moveSouth(10);
        assertEquals(new Coordinates(10, -9), wayPoint.getCoordinates());

    }

    @Test
    void moveEast() {
        WayPoint wayPoint = new WayPoint();
        wayPoint.moveEast(10);
        assertEquals(new Coordinates(20, 1), wayPoint.getCoordinates());

    }

    @Test
    void moveWest() {
        WayPoint wayPoint = new WayPoint();
        wayPoint.moveWest(10);
        assertEquals(new Coordinates(0, 1), wayPoint.getCoordinates());

    }
}