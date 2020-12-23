package com.maartenmusic.util;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class Coordinates implements Comparable<Coordinates>{
    private int x;
    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates move(int x, int y) {
        return new Coordinates(this.x + x, this.y + y);
    }

    @Override
    public int compareTo(Coordinates o) {
        return Comparator
                .comparingInt(Coordinates::getY)
                .thenComparingInt(Coordinates::getX)
                .compare(this, o);
    }
}
