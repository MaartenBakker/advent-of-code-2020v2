package com.maartenmusic.day13;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Day13Test {

    @Test
    void getResultOfPart1() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        int result = Day13.getResultOfPart1(txtFile);
        assertEquals(295, result);
    }

    @Test
    void getResultOfPart2() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        long result = Day13.getResultOfPart2(txtFile);
        assertEquals(1068781, result);
    }
}