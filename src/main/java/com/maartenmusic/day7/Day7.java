package com.maartenmusic.day7;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

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
    private static int bagCount;

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/com/maartenmusic/day7/testInput.txt");
        Map<String, Map<String, Integer>> rules = FileReaders.readTxtFileIntoMapOfColorsAndColorAmounts(txtFile);
        findTotalAmountOfBags("shinygold", rules);
        System.out.println(bagCount-1);

        bagCount = 0;

        txtFile = new File("src/main/java/com/maartenmusic/day7/testInput2.txt");
        rules = FileReaders.readTxtFileIntoMapOfColorsAndColorAmounts(txtFile);
        findTotalAmountOfBags("shinygold", rules);
        System.out.println(bagCount-1);

        bagCount = 0;

        txtFile = new File(FilePathGenerator.getFilePath("day7"));
        rules = FileReaders.readTxtFileIntoMapOfColorsAndColorAmounts(txtFile);
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

    static private List<Bag> getAmountOfBags(int amount, String color) {
        List<Bag> bags = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            bags.add(new Bag(color));
        }

        return bags;
    }


    private static void printResultOfPart1(File txtFile) {
        Map<String, ArrayList<String>> rules = FileReaders.readTxtFileIntoMapOfBagsAndColors(txtFile);

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
