package com.maartenmusic.day6;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day6"));

        ArrayList<ArrayList<String>> data = FileReaders.txtToStrings2d(txtFile);

        printResultOfPart1(data);
        printResultOfPart2(data);
    }

    private static void printResultOfPart1(ArrayList<ArrayList<String>> data) {
        int resultPart1 = data.stream()
                .map(Day6::listOfWordsToMapOfUniqueLetters)
                .map(Set::size)
                .reduce(0, Integer::sum);

        System.out.println("Part one answer: " + resultPart1);
    }

    private static void printResultOfPart2(ArrayList<ArrayList<String>> data) {
        AtomicLong groupSize = new AtomicLong();

        int resultPart2 = data.stream()
                .peek(list -> groupSize.set(list.size()))
                .map(Day6::listOfWordsToListOfLetters)
                .map(Day6::getMapOfAnswersAndFrequency)
                .map(Map::values)
                .map(valueList -> filterValuesEqualToGroupSize(valueList, groupSize)
                .collect(Collectors.toList()))
                .map(List::size)
                .reduce(0, Integer::sum);

        System.out.println("Part two answer: " + resultPart2);
    }

    private static Set<String> listOfWordsToMapOfUniqueLetters(ArrayList<String> list) {
        Set<String> letters = new HashSet<>();
        list.forEach(word -> {
            String[] strArr = word.split("");
            Collections.addAll(letters, strArr);
        });

        return letters;
    }

    private static List<String> listOfWordsToListOfLetters(ArrayList<String> list) {
        List<String> letters = new ArrayList<>();
        list.forEach(word -> {
            String[] strArr = word.split("");
            Collections.addAll(letters, strArr);
        });

        return letters;
    }

    static Map<String, Long> getMapOfAnswersAndFrequency(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Stream<Long> filterValuesEqualToGroupSize(Collection<Long> frequencyList, AtomicLong groupSize) {
        return frequencyList.stream()
                .filter(frequency -> frequency == groupSize.longValue());
    }
}
