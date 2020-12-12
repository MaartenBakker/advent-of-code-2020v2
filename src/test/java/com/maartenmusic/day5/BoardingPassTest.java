package com.maartenmusic.day5;

import com.maartenmusic.util.ArrayGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {

    @Test
    public void BoardingPass() {
        BoardingPass boardingPass = new BoardingPass("FFFFFFFLLL");
        Seat seat = new Seat(0,0);

        assertEquals(seat.getColumn(), boardingPass.getSeat().getColumn());
        assertEquals(seat.getRow(), boardingPass.getSeat().getRow());

        boardingPass = new BoardingPass("BBBBBBBRRR");
        seat = new Seat(127, 7);

        assertEquals(seat.getColumn(), boardingPass.getSeat().getColumn());
        assertEquals(seat.getRow(), boardingPass.getSeat().getRow());
    }

    @Test
    public void BoardingPassSeatNotFound() {

        assertThrows(SeatNotFoundError.class, ()-> {
            BoardingPass boardingPass = new BoardingPass("ABCDEFGHIJ");
        });

    }

    @Test
    public void splitArrayInTwo() {
        BoardingPass boardingPass = new BoardingPass("FFFFFFFLLL");
        int[] wholeArray = {0,1,2,3,4,5,6,7};
        System.out.println(Arrays.deepToString(boardingPass.splitArrayInTwo(wholeArray)));
    }
}