package com.maartenmusic.day10;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

class Day10Test {

    @Test
    void countPermutations() {
        File file = new File("src/test/java/com/maartenmusic/day10/testInput.txt");
        List<Integer> data = TxtFileReaders.toIntegers(file);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        System.out.println(Day10.countPermutations(data));

        file = new File("src/test/java/com/maartenmusic/day10/testInput2.txt");
        data = TxtFileReaders.toIntegers(file);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        System.out.println(Day10.countPermutations(data));
    }
}