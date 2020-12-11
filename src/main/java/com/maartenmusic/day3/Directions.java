package com.maartenmusic.day3;

public class Directions {
    private int moveRight;
    private int moveDown;

    public Directions(int moveRight, int moveDown) {
        this.moveRight = moveRight;
        this.moveDown = moveDown;
    }

    public int getMoveRight() {
        return moveRight;
    }

    public int getMoveDown() {
        return moveDown;
    }
}
