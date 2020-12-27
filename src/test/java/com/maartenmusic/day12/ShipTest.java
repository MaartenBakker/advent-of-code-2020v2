package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void followActions() {
        ShipAction shipAction1 = new ShipAction('N', 10);
        ShipAction shipAction2 = new ShipAction('E', 10);
        ShipAction shipAction3 = new ShipAction('R', 90);
        ShipAction shipAction4 = new ShipAction('F', 10);

        List<ShipAction> shipActions = Arrays.asList(shipAction1, shipAction2, shipAction3, shipAction4);

        Ship ship = new Ship();
        ship.followActions(shipActions);

        assertEquals(new Coordinates(10, 0), ship.getCoordinates());

    }

    @Test
    void goForward() {
        Ship ship = new Ship();
        ship.goForward(10);
        assertEquals(new Coordinates(10, 0), ship.getCoordinates());

        ship.turn(90);
        ship.goForward(100);
        assertEquals(new Coordinates(10, -100), ship.getCoordinates());
    }

    @Test
    void consumeAction() {
        Ship ship = new Ship();

        ShipAction moveNorth = new ShipAction('N', 1);
        ship.consumeAction(moveNorth);
        assertEquals(new Coordinates(0, 1), ship.getCoordinates());

        ShipAction moveSouth = new ShipAction('S', 2);
        ship.consumeAction(moveSouth);
        assertEquals(new Coordinates(0, -1), ship.getCoordinates());

        ShipAction moveEast = new ShipAction('E', 10);
        ship.consumeAction(moveEast);
        assertEquals(new Coordinates(10, -1), ship.getCoordinates());

        ShipAction moveWest = new ShipAction('W', 11);
        ship.consumeAction(moveWest);
        assertEquals(new Coordinates(-1, -1), ship.getCoordinates());

        ShipAction turnRight = new ShipAction('R', 90);
        ship.consumeAction(turnRight);
        assertEquals(Ship.Direction.SOUTH, ship.getDirection());
    }

    @Test
    void consumeActionIllegalAction() {
        Ship ship = new Ship();
        ShipAction illegalShipAction = new ShipAction('Q', 30);
        assertThrows(IllegalActionException.class, ()-> ship.consumeAction(illegalShipAction));
    }

    @Test
    void move() {
        Ship ship = new Ship();
        assertEquals(new Coordinates(), ship.getCoordinates());

        ship.move(1,1);
        assertEquals(new Coordinates(1,1), ship.getCoordinates());

        ship.move(-2,-2);
        assertEquals(new Coordinates(-1,-1), ship.getCoordinates());

    }

    @Test
    void turn() {
        Ship ship = new Ship();
        assertEquals(Ship.Direction.EAST, ship.getDirection());

        ship.turn(90);
        assertEquals(Ship.Direction.SOUTH, ship.getDirection());

        ship.turn(90);
        assertEquals(Ship.Direction.WEST, ship.getDirection());

        ship.turn(180);
        assertEquals(Ship.Direction.EAST, ship.getDirection());

        ship.turn(-90);
        assertEquals(Ship.Direction.NORTH, ship.getDirection());

        ship.turn(-360);
        assertEquals(Ship.Direction.NORTH, ship.getDirection());

        ship.turn(-1080);
        assertEquals(Ship.Direction.NORTH, ship.getDirection());
    }

    @Test
    void turnNotDivisibleBy90() {
        Ship ship = new Ship();
        assertThrows(IllegalDegreesException.class, ()-> ship.turn(50));
    }

    @Test
    void getQuarterTurns() {
        Ship ship = new Ship();
        System.out.println(ship.getQuarterTurns(360));
        System.out.println(ship.getQuarterTurns(720));
        System.out.println(ship.getQuarterTurns(450));
        System.out.println(ship.getQuarterTurns(-450));
        System.out.println(ship.getQuarterTurns(-1080));
    }
}