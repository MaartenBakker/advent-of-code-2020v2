package com.maartenmusic.day3;

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


    public Coordinates goNorthWest() {
        return new Coordinates(this.x-1, this.y-1);
    }
    public Coordinates goNorth() {
        return new Coordinates(this.x, this.y-1);
    }

    public Coordinates goNorthEast() {
        return new Coordinates(this.x+1, this.y-1);
    }

    public Coordinates goEast() {
        return new Coordinates(this.x+1, this.y);
    }

    public Coordinates goSouthEast() {
        return new Coordinates(this.x+1, this.y+1);
    }

    public Coordinates goSouth() {
        return new Coordinates(this.x, this.y+1);
    }

    public Coordinates goSouthWest() {
        return new Coordinates(this.x-1, this.y+1);
    }

    public Coordinates goWest() {
        return new Coordinates(this.x-1, this.y);
    }





    @Override
    public int compareTo(Coordinates o) {
        return Comparator
                .comparingInt(Coordinates::getY)
                .thenComparingInt(Coordinates::getX)
                .compare(this, o);
    }
}
