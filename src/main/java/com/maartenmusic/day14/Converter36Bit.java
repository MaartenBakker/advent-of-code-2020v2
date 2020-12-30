package com.maartenmusic.day14;

import java.util.stream.IntStream;

public class Converter36Bit {

    static String to36BitString(Long number) {
        String binary = Long.toBinaryString(number);
        int missingZeros = 36 - binary.length();

        return  "0".repeat(missingZeros) +
                binary;
    }
}
