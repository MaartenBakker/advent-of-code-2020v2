package com.maartenmusic.day12;

import com.maartenmusic.util.Coordinates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WayPoint {
    private Coordinates coordinates = new Coordinates(10, 1);

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
}
