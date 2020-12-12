package com.maartenmusic.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayGeneratorTest {

    @Test
    public void createFilledArray() {
        System.out.println(Arrays.toString(ArrayGenerator.createFilledArray(1, 10)));
        System.out.println(Arrays.toString(ArrayGenerator.createFilledArray(0, 10)));
        System.out.println(Arrays.toString(ArrayGenerator.createFilledArray(5, 14)));
    }

}