package com.maartenmusic.day5;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;


import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    public static void main(String[] args) {
        File file = new File(FilePathGenerator.getFilePath("day5"));

        List<BoardingPass> boardingPasses = FileReaders
                .readTxtFileIntoArrayListOfStrings(file)
                .stream()
                .map(BoardingPass::new)
                .collect(Collectors.toList());

    }
}
