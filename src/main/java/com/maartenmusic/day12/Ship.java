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

    void move(int x, int y) {
        this.coordinates = this.coordinates.move(x, y);
    }


    void turn(int degrees) {
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
