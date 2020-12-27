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
    public void followActions(List<Action> actions) {
        actions.forEach(this::consumeAction);
    }

    @Override
    void consumeAction(Action action) {
        switch (action.getType()) {
            case 'N':
                wayPoint.moveNorth(action.getValue());
                break;
            case 'S':
                wayPoint.moveSouth(action.getValue());
                break;
            case 'E':
                wayPoint.moveEast(action.getValue());
                break;
            case 'W':
                wayPoint.moveWest(action.getValue());
                break;
            case 'R':
                turn(action.getValue());
                break;
            case 'L':
                turn(-action.getValue());
                break;
            case 'F':
                goTowardsWayPoint(action.getValue());
                break;
            default:
                throw new IllegalActionException("Can't process the given action: " + action.getType());
        }
    }

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
