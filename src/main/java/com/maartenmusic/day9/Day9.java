package com.maartenmusic.day9;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day9 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day9"));

        List<Long> data = FileReaders.readTxtFileIntoArrayListOfLong(txtFile);

        //Solution of part 1
        System.out.println(getFirstNumberThatDoesNotFollowRule(data));
    }

    public static Long getFirstNumberThatDoesNotFollowRule(List<Long> data) {
        List<Long> subList;
        Long number;

        for (int i = 0; i < data.size() - 25; i++) {
            subList = data.subList(i, i + 25);
            number = data.get(i + 25);
            if(!twoDistinctNumbersFromListAddUpToNumber(subList, number)) {
                return number;
            }
        }
        return -1L;
    }

    static boolean twoDistinctNumbersFromListAddUpToNumber(List<Long> numberList, Long number) {
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
