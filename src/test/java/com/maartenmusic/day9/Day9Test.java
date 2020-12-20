package com.maartenmusic.day9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

    @Test
    void twoDistinctNumbersFromListAddUpToNumber() {
        Long number = 50L;
        List<Long> numberList1 = Arrays.asList(1L, 2L, 25L);
        List<Long> numberList2 = Arrays.asList(1L, 2L, 24L, 26L);

        assertFalse(Day9.twoDistinctNumbersFromListAddUpToNumber(numberList1, number));
        assertTrue(Day9.twoDistinctNumbersFromListAddUpToNumber(numberList2, number));
    }

    @Test
    void getFirstNumberThatDoesNotFollowRule() {
        List<Integer> subList;
        List<Integer> data = Arrays.asList(1,2,3,4,5,6);

        for (int i = 0; i < data.size() - 4; i++) {
            subList = data.subList(i, i + 5);
            System.out.println(subList);
        }
    }

    @Test
    void getListOfContiguousNumbersThatAddUpToNumber() {
        List<Long> numberList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        Long number = 12L;
        List<Long> expectedResultList = Arrays.asList(3L, 4L, 5L);
        List<Long> failList = Arrays.asList(-1L);

        List<Long> resultList = Day9.ContiguousNumbersThatSumToNumber(numberList, number);

        assertEquals(expectedResultList, resultList);

        resultList = Day9.ContiguousNumbersThatSumToNumber(numberList, 50L);

        assertEquals(failList, resultList);

    }
}