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

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day7"));
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
