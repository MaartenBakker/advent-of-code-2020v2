package com.maartenmusic.day9;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day9 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day9"));

        List<Long> data = FileReaders.readTxtFileIntoArrayListOfLong(txtFile);

        printResultOfPart1(data);
    }

    public static void printResultOfPart1(List<Long> data) {
        List<Long> subList;
        twoNumbersFromListAddUpToNumber(data, 50L);

    }

    static boolean twoNumbersFromListAddUpToNumber(List<Long> numberList, Long number) {
        for (Long listNumber: numberList) {
            if (number - listNumber != listNumber) {
                int index = numberList.indexOf(number - listNumber);
                if (index != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
