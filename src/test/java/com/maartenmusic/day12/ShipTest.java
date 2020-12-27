package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

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
    void getQuarterTurns() {
        Ship ship = new Ship();
        System.out.println(ship.getQuarterTurns(360));
        System.out.println(ship.getQuarterTurns(720));
        System.out.println(ship.getQuarterTurns(450));
        System.out.println(ship.getQuarterTurns(-450));
        System.out.println(ship.getQuarterTurns(-1080));
    }
}