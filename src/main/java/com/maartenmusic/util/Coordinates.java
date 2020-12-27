package com.maartenmusic.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
public class Coordinates implements Comparable<Coordinates>{
    private int x;
    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates move(int x, int y) {
        return new Coordinates(this.x + x, this.y + y);
    }

    public int manhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(Coordinates o) {
        return Comparator
                .comparingInt(Coordinates::getY)
                .thenComparingInt(Coordinates::getX)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
