package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Ship {
    private Coordinates coordinates;
    private Direction direction;

    public Ship() {
        this.coordinates = new Coordinates();
        this.direction = Direction.EAST;
    }

    public void followActions(List<ShipAction> shipActions) {
        shipActions.forEach(this::consumeAction);
    }

    void consumeAction(ShipAction shipAction) {
        switch (shipAction.getType()) {
            case 'N':
                moveNorth(shipAction.getValue());
                break;
            case 'S':
                moveSouth(shipAction.getValue());
                break;
            case 'E':
                moveEast(shipAction.getValue());
                break;
            case 'W':
                moveWest(shipAction.getValue());
                break;
            case 'R':
                turn(shipAction.getValue());
                break;
            case 'L':
                turn(-shipAction.getValue());
                break;
            case 'F':
                goForward(shipAction.getValue());
                break;
            default:
                throw new IllegalActionException("Can't process the given action");
        }
    }

    void goForward(int value) {
        switch(direction) {
            case NORTH: moveNorth(value);
            break;
            case EAST: moveEast(value);
            break;
            case SOUTH: moveSouth(value);
            break;
            case WEST: moveWest(value);
        }
    }

    void moveNorth(int value){
        move(0, value);
    }

    void moveSouth(int value) {
        move(0, -value);
    }

    void moveEast(int value) {
        move(value, 0);
    }

    void moveWest(int value) {
        move(-value, 0);
    }

    void move(int x, int y) {
        coordinates = coordinates.move(x, y);
    }

    void turn(int degrees) {
        if (degrees % 90 != 0) {
            throw new IllegalDegreesException("Degrees not divisible by 90");
        }

        List<Direction> directionList = Arrays.asList(Direction.values());
        int currentDirectionIndex = directionList.indexOf(this.direction);

        int quarterTurns = getQuarterTurns(degrees);

        int resultDirectionIndex = currentDirectionIndex + quarterTurns;

        if (resultDirectionIndex >= directionList.size()) {
            resultDirectionIndex -= directionList.size();
        }

        if (resultDirectionIndex < 0) {
            resultDirectionIndex += directionList.size();
        }

        this.direction = directionList.get(resultDirectionIndex);
    }

    int getQuarterTurns(int degrees) {
        if (degrees > 360) {
            while (degrees > 360)
                degrees -= 360;
        }

        if (degrees < -360) {
            while (degrees < -360) {
               degrees += 360;
            }
        }

        return degrees / 90;
    }


    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}
