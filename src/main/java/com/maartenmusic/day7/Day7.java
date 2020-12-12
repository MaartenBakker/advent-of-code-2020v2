package com.maartenmusic.day7;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;
import com.sun.source.doctree.SeeTree;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 {

//    read data into map of rules (color : arrayOfColors)
//    if 2nd part contains shiny gold -> add 1st part to resultsList;
//    for each item in resultsList ->
//    if 2nd part contains item name -> add 1st part to 2nd resultsList;
//    keep going deeper until no results are found (flag?)
//    merge lists

    private static final List<ArrayList<String>> resultsList = new ArrayList<>();


    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day7"));

        Map<String, ArrayList<String>> rules = FileReaders.readTxtFileIntoMapOfBagsAndColors(txtFile);

        findBagsThatContainColor(rules, "shinygold");

//        resultsList.forEach(System.out::println);

        Set<String> combinedResults = new HashSet<>();
        resultsList.forEach(combinedResults::addAll);

        combinedResults.stream().sorted().forEach(System.out::println);
        System.out.println(combinedResults.size());
    }

    private static void findBagsThatContainColor(Map<String, ArrayList<String>> rules, String color) {
        findBagsThatContainColor(rules, color, 0);
    }

    private static void findBagsThatContainColor(Map<String, ArrayList<String>> rules, String color, int counter) {

        ArrayList<String> results = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry: rules.entrySet()) {
            if(entry.getValue().contains(color)) {
                results.add(entry.getKey());
            }
        }

        if (!results.isEmpty()) {
            resultsList.add(results);

            for(String foundColor : resultsList.get(counter)) {
                findBagsThatContainColor(rules, foundColor, counter + 1);
            }
        }
    }

}
