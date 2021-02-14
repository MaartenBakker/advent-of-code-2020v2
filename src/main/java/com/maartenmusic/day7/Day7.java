package com.maartenmusic.day7;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.*;

public class Day7 {

//    read data into map of rules (color : arrayOfColors)
//    if 2nd part contains shiny gold -> add 1st part to resultsList;
//    for each item in resultsList ->
//    if 2nd part contains item name -> add 1st part to 2nd resultsList;
//    keep going deeper until no results are found (flag?)
//    merge lists

    private static final Set<String> results = new HashSet<>();
    static int bagCount;

    public static void main(String[] args) {

        bagCount = 0;
        File txtFile = new File(FilePathGenerator.generate("day7"));

        printResultOfPart1(txtFile);
        printResultOfPart2(txtFile);
    }

    private static void printResultOfPart2(File txtFile) {
        Map<String, Map<String, Integer>> rules = TxtFileReaders.toColorAndAmountMap(txtFile);
        findTotalAmountOfBags("shinygold", rules);
        System.out.println(bagCount-1);
    }

    static void findTotalAmountOfBags(String color, Map<String, Map<String, Integer>> rules) {
        bagCount++;

        Map<String, Integer> containedBags = rules.get(color);

        containedBags.forEach((bagColor, amount)  -> {
            for (int i = 0; i < amount; i++) {
                findTotalAmountOfBags(bagColor, rules);
            }
        });
    }

    private static void printResultOfPart1(File txtFile) {
        Map<String, ArrayList<String>> rules = TxtFileReaders.toBagAndColorsMap(txtFile);

        Set<String> results = findBagsThatContainColor( "shinygold", rules);

        System.out.println(results.size());
    }

    private static Set<String> findBagsThatContainColor(String color, Map<String, ArrayList<String>> rules) {

        for (Map.Entry<String, ArrayList<String>> entry: rules.entrySet()) {
            if(entry.getValue().contains(color)) {
                results.add(entry.getKey());
                findBagsThatContainColor(entry.getKey(), rules);
            }
        }

        return results;
    }

}
