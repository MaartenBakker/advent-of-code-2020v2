package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WayPointShipTest {

    @Test
    void followActions() {
        ShipAction shipAction1 = new ShipAction('N', 10);
        ShipAction shipAction2 = new ShipAction('E', 10);
        ShipAction shipAction3 = new ShipAction('S', 90);
        ShipAction shipAction4 = new ShipAction('W', 10);
        ShipAction shipAction5 = new ShipAction('R', 180);
        ShipAction shipAction6 = new ShipAction('L', 90);

        List<ShipAction> shipActions = Arrays.asList(shipAction1, shipAction2, shipAction3, shipAction4, shipAction5, shipAction6);

        WayPointShip ship = new WayPointShip();
        ship.followActions(shipActions);

        assertEquals(new Coordinates(-79, -10), ship.getWaypointCoordinates());
    }

    @Test
    void consumeAction() {
        WayPointShip ship = new WayPointShip();

        ShipAction moveWayPointNorth = new ShipAction('N', 1);
        ship.consumeAction(moveWayPointNorth);
        assertEquals(new Coordinates(10, 2), ship.getWaypointCoordinates());
    }

    @Test
    void goTowardsWayPoint() {
        WayPointShip ship = new WayPointShip();
        ship.goTowardsWayPoint(10);
        assertEquals(new Coordinates(100, 10), ship.getCoordinates());
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