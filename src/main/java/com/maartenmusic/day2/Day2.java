package com.maartenmusic.day2;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.generate("day2"));
        List<String> data = TxtFileReaders.toStrings(txtFile);

        printResultPart1(data);
        printResultPart2(data);
    }
    private static void printResultPart1(List<String> data) {
//        getArrayItem(data);
//        == create object ==
//        splitIntoThreeParts(arrayItem);
//        defineAcceptableRange(rangePart);
//        defineLetter(letterPart);
//        getFrequencyOfLetter(passwordPart);
//        validatePassword(acceptableRange, frequency);
//            if(valid) {
//                AddToCount();
//            }
//        printCount();

        System.out.println(data.stream()
                .map(Day2::getPasswordObjectFreqFromString)
                .filter(PasswordFreq::checkRange)
                .count());
    }

    private static void printResultPart2(List<String> data) {
        System.out.println(data.stream()
                .map(Day2::getPasswordObjectPosFromString)
                .filter(PasswordPos::checkPositions)
                .count());
    }

    private static PasswordPos getPasswordObjectPosFromString(String data) {
        PasswordDTO passwordDto = getPasswordData(data);

        return new PasswordPos(passwordDto.getFirstNumber(), passwordDto.getSecondNumber(), passwordDto.getLetter(), passwordDto.getPassword());
    }

    private static PasswordFreq getPasswordObjectFreqFromString(String data) {
        PasswordDTO passwordDto = getPasswordData(data);

        return new PasswordFreq(passwordDto.getFirstNumber(), passwordDto.getSecondNumber(), passwordDto.getLetter(), passwordDto.getPassword());
    }

    private static PasswordDTO getPasswordData(String data) {
        String[] dataParts = data.split(" ");

        String rangePart = dataParts[0];
        String letterPart = dataParts[1];
        String password = dataParts[2];

        int firstNumber = getFirstNumberFromRangePart(rangePart);
        int secondNumber = getSecondNumberFromRangePart(rangePart);
        char letter = letterPart.charAt(0);

        return new PasswordDTO(firstNumber, secondNumber, letter, password);
    }

    private static int getFirstNumberFromRangePart(String rangePart) {
        String[] splitRangePart = rangePart.split("-");
        return Integer.parseInt(splitRangePart[0]);
    }

    private static int getSecondNumberFromRangePart(String rangePart) {
        String[] splitRangePart = rangePart.split("-");
        return Integer.parseInt(splitRangePart[1]);
    }
}
