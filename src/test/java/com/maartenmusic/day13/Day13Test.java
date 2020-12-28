package com.maartenmusic.day13;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

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
        BigInteger result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("1068781"), result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput2.txt");
        result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("3417"), result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput3.txt");
        result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("754018"), result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput4.txt");
        result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("779210"), result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput5.txt");
        result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("1261476"), result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput6.txt");
        result = Day13.getResultOfPart2(txtFile);
        assertEquals(new BigInteger("1202161486"), result);

    }
}