package com.maartenmusic.day1;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {

        File txtFile = new File(FilePathGenerator.getFilePath("day1"));

    
        List<Integer> data = FileReaders.txtToLongs(txtFile);

        int goal = 2020;

        printResultPart1(data, goal);
        printResultPart2(data, goal);
    }

    private static void printResultPart1(List<Integer> data, int goal) {

        int numberAtPointer1;
        int numberAtPointer2;

        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                numberAtPointer1 = data.get(i);
                numberAtPointer2 = data.get(j);

                if (numberAtPointer1 + numberAtPointer2 == goal ) {
                    System.out.println("The answer is: " + numberAtPointer1 * numberAtPointer2);
                }
            }
        }
    }

    private static void printResultPart2(List<Integer> data, int goal) {

        int numberAtPointer1;
        int numberAtPointer2;
        int numberAtPointer3;

        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                for (int k = j + 1; k < data.size(); k++) {
                    numberAtPointer1 = data.get(i);
                    numberAtPointer2 = data.get(j);
                    numberAtPointer3 = data.get(k);

                    if (numberAtPointer1 + numberAtPointer2 + numberAtPointer3 == goal) {
                        System.out.println("The answer is: " + numberAtPointer1 * numberAtPointer2 * numberAtPointer3);
                    }
                }
            }
        }
    }



}
