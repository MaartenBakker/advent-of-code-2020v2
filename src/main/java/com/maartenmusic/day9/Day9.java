package com.maartenmusic.day9;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day9 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day9"));

        List<Long> data = FileReaders.txtToIntegers(txtFile);

        //Solution of part 1
        System.out.println(getFirstNumberThatDoesNotFollowRule(data));

        //Solution of part 2
        Long numberFoundInPartOne = getFirstNumberThatDoesNotFollowRule(data);
        List<Long> resultList = getListOfContiguousNumbersThatAddUpToNumber(data, numberFoundInPartOne);
        System.out.println(sumOfSmallestAndLargestNumber(resultList));
    }

    public static Long sumOfSmallestAndLargestNumber(List<Long> numberList) {
        return Collections.max(numberList) + Collections.min(numberList);
    }

    public static List<Long> getListOfContiguousNumbersThatAddUpToNumber(List<Long> numberList, Long number) {
        List<Long> resultList;

        for (int i = 0; i < numberList.size(); i++) {
            resultList = new ArrayList<>();
            for (int j = i; j < numberList.size(); j++) {
                resultList.add(numberList.get(j));
                Long sum = resultList.stream().reduce(Long::sum).get();
                if (sum > number) {
                    break;
                } else if (sum.equals(number)) {
                    return resultList;
                }
            }
        }
        return Arrays.asList(-1L);
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
