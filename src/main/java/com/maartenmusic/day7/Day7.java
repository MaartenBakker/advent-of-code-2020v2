package com.maartenmusic.day7;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Day7 {

//    read data into map of rules (color : arrayOfColors)
//    if 2nd part contains shiny gold -> add 1st part to resultsList;
//    for each item in resultsList ->
//    if 2nd part contains item name -> add 1st part to 2nd resultsList;
//    keep going deeper until no results are found (flag?)
//    merge lists

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day7"));

        Map<String, ArrayList<String>> rules = FileReaders.readTxtFileIntoMapOfBagsAndColors(txtFile);

        rules.values().stream().forEach(System.out::println);
    }

}
