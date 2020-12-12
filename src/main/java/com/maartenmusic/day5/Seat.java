package com.maartenmusic.day5;

import lombok.Data;

@Data
public class Seat {
    private final int row;
    private final int column;
    private final int id;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.id = this.row * 8 + this.column;
    }
}
