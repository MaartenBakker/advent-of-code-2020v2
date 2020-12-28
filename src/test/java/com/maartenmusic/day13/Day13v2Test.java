package com.maartenmusic.day13;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class Day13v2Test {

    @Test
    @Disabled
    void resultOfPart2() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        long result = Day13v2.resultOfPart2(txtFile);
        assertEquals(1068781L, result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput2.txt");
        result = Day13v2.resultOfPart2(txtFile);
        assertEquals(3417L, result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput3.txt");
        result = Day13v2.resultOfPart2(txtFile);
        assertEquals(754018L, result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput4.txt");
        result = Day13v2.resultOfPart2(txtFile);
        assertEquals(779210L, result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput5.txt");
        result = Day13v2.resultOfPart2(txtFile);
        assertEquals(1261476L, result);

        txtFile = new File("src/test/java/com/maartenmusic/day13/testInput6.txt");
        result = Day13v2.resultOfPart2(txtFile);
        assertEquals(1202161486L, result);

    }


}