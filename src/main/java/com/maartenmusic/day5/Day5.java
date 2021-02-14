package com.maartenmusic.day5;

import com.maartenmusic.util.ArrayGenerator;
import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    public static void main(String[] args) {
        File file = new File(FilePathGenerator.generate("day5"));

        printResultOfPart1(file);

        printResultOfPart2(file);
    }

    private static void printResultOfPart2(File file) {
        int[] allIdsArray = ArrayGenerator.createFilledArray(45, 953);
        List<Integer> allIds = new ArrayList<>();

        for (int id : allIdsArray) {
            allIds.add(id);
        }

        List<Integer> myIds = TxtFileReaders
                .toStrings(file)
                .stream()
                .map(BoardingPass::new)
                .map(BoardingPass::getSeat)
                .map(Seat::getId)
                .collect(Collectors.toList());

        allIds.removeAll(myIds);

        allIds.forEach(System.out::println);
    }

    private static void printResultOfPart1(File file) {
        TxtFileReaders
                .toStrings(file)
                .stream()
                .map(BoardingPass::new)
                .map(BoardingPass::getSeat)
                .map(Seat::getId)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }
}
