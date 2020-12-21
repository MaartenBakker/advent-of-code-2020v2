package com.maartenmusic.day7;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    @Test
    public void findTotalAmountOfBags() {

        File txtFile = new File("src/test/java/com/maartenmusic/day7/testInput.txt");
        Map<String, Map<String, Integer>> rules = FileReaders.txtToColorAndAmountMap(txtFile);
        Day7.findTotalAmountOfBags("shinygold", rules);
        assertEquals(126, Day7.bagCount-1);

        Day7.bagCount = 0;

        txtFile = new File("src/test/java/com/maartenmusic/day7/testInput2.txt");
        rules = FileReaders.txtToColorAndAmountMap(txtFile);
        Day7.findTotalAmountOfBags("shinygold", rules);
        assertEquals(32, Day7.bagCount-1);
        Day7.bagCount = 0;
    }
}