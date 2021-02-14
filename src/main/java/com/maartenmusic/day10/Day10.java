package com.maartenmusic.day10;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class Day10 {

    public static void main(String[] args) {

        File txtFile = new File(FilePathGenerator.generate("day10"));
        List<Integer> data = TxtFileReaders.toIntegers(txtFile);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        printResultOfPartOne(data);

        System.out.println(countPermutations(data));
    }

    public static BigInteger countPermutations(List<Integer> data) {
        int twoConsecutiveOnes = 0;
        int threeConsecutiveOnes = 0;
        int fourConsecutiveOnes = 0;

        System.out.println(data);

        for (int i = 0; i < data.size() ; i++) {
            if(i + 4 < data.size()) {
                if (data.get(i + 1) - data.get(i) == 1 &&
                    data.get(i + 2) - data.get(i + 1) == 1 &&
                    data.get(i + 3) - data.get(i + 2) == 1 &&
                    data.get(i + 4) - data.get(i +3) == 1
                ) {
                    fourConsecutiveOnes++;
                    i += 4;

                    continue;
                }
            }

            if(i + 3 < data.size()) {
                if (data.get(i + 1) - data.get(i) == 1 &&
                    data.get(i + 2) - data.get(i + 1) == 1 &&
                    data.get(i + 3) - data.get(i + 2) == 1
                ) {
                    threeConsecutiveOnes++;
                    i += 3;

                    continue;
                }
            }

            if(i + 2 < data.size()) {
               if (data.get(i + 1) - data.get(i) == 1 &&
                   data.get(i + 2) - data.get(i + 1) == 1
               ) {
                    twoConsecutiveOnes++;
                    i += 2;
                }
            }
        }

        System.out.println("2's: " + twoConsecutiveOnes);
        System.out.println("3's: " + threeConsecutiveOnes);
        System.out.println("4's: " + fourConsecutiveOnes);

        BigInteger twos = new BigInteger("2"); // two 1's in a row create 2 permutations
        BigInteger twosPowered = twos.pow(twoConsecutiveOnes);

        BigInteger threes = new BigInteger("4"); // three 1's in a row create 4 permutations
        BigInteger threesPowered = threes.pow(threeConsecutiveOnes);

        BigInteger fours = new BigInteger("7"); // four 1's in a row create 7 permutations
        BigInteger foursPowered = fours.pow(fourConsecutiveOnes);

        return twosPowered.multiply(threesPowered).multiply(foursPowered);
    }

    public static void printResultOfPartOne(List<Integer> data) {
        int diffOfOne = 0;
        int diffOfThree = 0;

        for (int i = 1; i < data.size(); i++) {
            int diff = data.get(i) - data.get(i - 1);
            if (diff == 1) {
                diffOfOne++;
            } else if (diff == 3) {
                diffOfThree++;
            }
        }
        System.out.println(diffOfOne * diffOfThree);
    }
}
