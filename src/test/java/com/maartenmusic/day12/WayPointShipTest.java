package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WayPointShipTest {

    @Test
    void followActions() {
        Action action1 = new Action('N', 10);
        Action action2 = new Action('E', 10);
        Action action3 = new Action('S', 90);
        Action action4 = new Action('W', 10);
        Action action5 = new Action('R', 180);
        Action action6 = new Action('L', 90);

        List<Action> actions = Arrays.asList(action1, action2, action3, action4, action5, action6);

        WayPointShip ship = new WayPointShip();
        ship.followActions(actions);

        assertEquals(new Coordinates(-79, -10), ship.getWaypointCoordinates());
    }

    @Test
    void consumeAction() {
        WayPointShip ship = new WayPointShip();

        Action moveWayPointNorth = new Action('N', 1);
        ship.consumeAction(moveWayPointNorth);
        assertEquals(new Coordinates(10, 2), ship.getWaypointCoordinates());
    }

    @Test
    void turn(){
        WayPointShip ship = new WayPointShip();
        assertEquals(new Coordinates(10, 1), ship.getWaypointCoordinates());
        ship.turn(90);
        assertEquals(new Coordinates(1, -10), ship.getWaypointCoordinates());
        ship.turn(90);
        assertEquals(new Coordinates(-10, -1), ship.getWaypointCoordinates());
        ship.turn(-90);
        assertEquals(new Coordinates(1, -10), ship.getWaypointCoordinates());
    }
}