package com.maartenmusic.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileReadersTest {

    @Test
    void readTxtFileIntoMapOfBagsAndColors() {

        File txtFile = new File(FilePathGenerator.getFilePath("day7"));

        Map<String, ArrayList<String>> rules = FileReaders.readTxtFileIntoMapOfBagsAndColors(txtFile);

        rules.keySet().stream().sorted().forEach(System.out::println);
        rules.values().forEach(System.out::println);
    }
}