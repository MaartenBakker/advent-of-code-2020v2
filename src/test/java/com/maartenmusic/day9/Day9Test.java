package com.maartenmusic.day9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

    @Test
    void twoNumbersFromListAddUpToNumber() {
        Long number = 50L;
        List<Long> numberList1 = Arrays.asList(1L, 2L, 25L);
        List<Long> numberList2 = Arrays.asList(1L, 2L, 24L, 26L);

        assertFalse(Day9.twoNumbersFromListAddUpToNumber(numberList1, number));
        assertTrue(Day9.twoNumbersFromListAddUpToNumber(numberList2, number));
    }
}