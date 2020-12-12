package com.maartenmusic.util;

public class ArrayGenerator {

    public static int[] createFilledArray(int startingNumber, int endingNumber) {
        int[] array = new int[endingNumber + 1 - startingNumber];

        for (int i = 0; i <= endingNumber - startingNumber; i++) {

            array[i] = i + startingNumber;
        }

        return array;
    }
}
