package com.maartenmusic.day6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

    @Test
    void getMapOfAnswersAndFrequency() {
        List<String> stringList = Arrays.asList("A", "A", "B", "B", "B");

        Map<String, Long> stringFreqMap = Day6.getMapOfAnswersAndFrequency(stringList);

        assertEquals(2, stringFreqMap.size());
        assertEquals(2, stringFreqMap.get("A"));
        assertEquals(3, stringFreqMap.get("B"));
    }
}