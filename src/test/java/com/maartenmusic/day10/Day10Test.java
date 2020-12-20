package com.maartenmusic.day10;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.Filer;
import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

    @Test
    void countPermutations() {
        File file = new File("src/main/java/com/maartenmusic/day10/testInput.txt");
        List<Integer> data = FileReaders.txtToIntegers(file);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        System.out.println(Day10.countPermutations(data));

        file = new File("src/main/java/com/maartenmusic/day10/testInput2.txt");
        data = FileReaders.txtToIntegers(file);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        System.out.println(Day10.countPermutations(data));
    }
}