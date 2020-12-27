package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void followActions() {
        Action action1 = new Action('N', 10);
        Action action2 = new Action('E', 10);
        Action action3 = new Action('R', 90);
        Action action4 = new Action('F', 10);

        List<Action> actions = Arrays.asList(action1, action2, action3, action4);

        Ship ship = new Ship();
        ship.followActions(actions);

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

        Action moveNorth = new Action('N', 1);
        ship.consumeAction(moveNorth);
        assertEquals(new Coordinates(0, 1), ship.getCoordinates());

        Action moveSouth = new Action('S', 2);
        ship.consumeAction(moveSouth);
        assertEquals(new Coordinates(0, -1), ship.getCoordinates());

        Action moveEast = new Action('E', 10);
        ship.consumeAction(moveEast);
        assertEquals(new Coordinates(10, -1), ship.getCoordinates());

        Action moveWest = new Action('W', 11);
        ship.consumeAction(moveWest);
        assertEquals(new Coordinates(-1, -1), ship.getCoordinates());

        Action turnRight = new Action('R', 90);
        ship.consumeAction(turnRight);
        assertEquals(Ship.Direction.SOUTH, ship.getDirection());
    }

    @Test
    void consumeActionIllegalAction() {
        Ship ship = new Ship();
        Action illegalAction = new Action('Q', 30);
        assertThrows(IllegalActionException.class, ()-> ship.consumeAction(illegalAction));
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