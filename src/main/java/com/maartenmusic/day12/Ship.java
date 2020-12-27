package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Ship {
    private final Coordinates coordinates;
    private Direction direction;

    public Ship() {
        this.coordinates = new Coordinates(0,0);
        this.direction = Direction.EAST;
    }

    void turnRight(int degrees) {
        List<Direction> directionList = Arrays.asList(Direction.values());
        int currentDirectionIndex = directionList.indexOf(this.direction);

        int quarterTurns = degrees / 45;
        int resultDirectionIndex = currentDirectionIndex + quarterTurns;

        if (resultDirectionIndex >= directionList.size()) {
            resultDirectionIndex -= directionList.size();
        }

        this.direction = directionList.get(resultDirectionIndex);
    }



    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}
