package com.maartenmusic.day5;

import com.maartenmusic.util.ArrayGenerator;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
public class BoardingPass {
    private final String binarySpacePartitioning;
    @Getter
    private final Seat seat;
    private int[] arrayOfRows;
    private int[] arrayOfColumns;

    public BoardingPass(String binarySpacePartitioning) {
        this.binarySpacePartitioning = binarySpacePartitioning;
        this.arrayOfRows = ArrayGenerator.createFilledArray(0, 127);
        this.arrayOfColumns = ArrayGenerator.createFilledArray(0, 7);
        this.seat = new Seat(getRowFromBSP(), getColumnFromBSP());
    }

    public int[][] splitArrayInTwo(int[] wholeArray) {
        int[][] arrayAandArrayB = new int[2][];
        arrayAandArrayB[0] = Arrays.copyOfRange(wholeArray, 0, wholeArray.length / 2);
        arrayAandArrayB[1] = Arrays.copyOfRange(wholeArray, wholeArray.length / 2, wholeArray.length);

        return arrayAandArrayB;
    }

    private int getRowFromBSP() {

        for (int i = 0; i < 7; i++) {
            int[][] arrayAandArrayB = splitArrayInTwo(this.arrayOfRows);

            if(binarySpacePartitioning.charAt(i) == 'F') {
                this.arrayOfRows = arrayAandArrayB[0];
            } else if(binarySpacePartitioning.charAt(i) == 'B'){
                this.arrayOfRows = arrayAandArrayB[1];
            } else {
                throw new SeatNotFoundError();
            }

        }

        return this.arrayOfRows[0];
    }

    private int getColumnFromBSP() {

        for (int i = 0; i < 3; i++) {
            int[][] arrayAandArrayB = splitArrayInTwo(this.arrayOfColumns);

            if(binarySpacePartitioning.charAt(i + 7) == 'L') {
                this.arrayOfColumns = arrayAandArrayB[0];
            } else if(binarySpacePartitioning.charAt(i + 7) == 'R'){
                this.arrayOfColumns = arrayAandArrayB[1];
            } else {
                throw new SeatNotFoundError();
            }

        }

        return this.arrayOfColumns[0];
    }


}
