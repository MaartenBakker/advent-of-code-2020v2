package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import lombok.Getter;

import java.util.List;

@Getter
public class WayPointShip extends Ship {
    private final WayPoint wayPoint = new WayPoint();

    public Coordinates getWaypointCoordinates() {
        return wayPoint.getCoordinates();
    }

    @Override
    public void followActions(List<ShipAction> shipActions) {
        shipActions.forEach(this::consumeAction);
    }

    @Override
    void consumeAction(ShipAction shipAction) {
        switch (shipAction.getType()) {
            case 'N':
                wayPoint.moveNorth(shipAction.getValue());
                break;
            case 'S':
                wayPoint.moveSouth(shipAction.getValue());
                break;
            case 'E':
                wayPoint.moveEast(shipAction.getValue());
                break;
            case 'W':
                wayPoint.moveWest(shipAction.getValue());
                break;
            case 'R':
                turn(shipAction.getValue());
                break;
            case 'L':
                turn(-shipAction.getValue());
                break;
            case 'F':
                goTowardsWayPoint(shipAction.getValue());
                break;
            default:
                throw new IllegalActionException("Can't process the given action: " + shipAction.getType());
        }
    }

    void goTowardsWayPoint(int value) {
        int newX = wayPoint.getCoordinates().getX() * value;
        int newY = wayPoint.getCoordinates().getY() * value;
        move(newX, newY);
    }

    @Override
    void turn(int degrees) {
        if (degrees % 90 != 0) {
            throw new IllegalDegreesException("Degrees not divisible by 90. Degrees: " + degrees);
        }

        int quarterTurns = getQuarterTurns(degrees);
        if(degrees < 0) {
            quarterTurns = 4 + quarterTurns;
        }

        for (int i = 0; i < quarterTurns ; i++) {
            int newY = -getWaypointCoordinates().getX();
            int newX = getWaypointCoordinates().getY();
            this.wayPoint.setCoordinates(new Coordinates(newX, newY));
        }
    }
}
