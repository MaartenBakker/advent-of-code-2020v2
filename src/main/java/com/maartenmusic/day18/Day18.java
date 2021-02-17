package com.maartenmusic.day18;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day18 {

    public static void main(String[] args) {
        // lees als string
        // per paar kunnen verwerken, paar vervangen door resultaat.
        // beginnen met secties tussen haakjes als losse regel te verwerken. Recursief.
        //
        // functie:
        // if contains regex met haakjes -> extract. recursief
        // else verwerk en replace

        String testString = "2 + (3 + 7 + 7) * 5 + 9 + (5 + (4 + 5 + 3 + 6) + 8 * 5 + (7 + 4 + 7 + 6 + 9) + 9)";

        File file = new File(FilePathGenerator.generate("day18"));
        List<String> inputStrings = TxtFileReaders.toStrings(file);
        inputStrings.forEach(System.out::println);
        System.out.println(
                inputStrings.stream()
                .map(Day18::processInputString)
                .map(Long::parseLong)
                .reduce(Long::sum)
        );



        System.out.println(processInputString(testString));
    }

    static String processInputString(String inputString) {
        while (inputString.contains(")")) {
            inputString = processParentheses(inputString);
        }
        return processWeirdMathString(inputString);
    }

    static String processParentheses(String inputString) {
        Pattern parentheses = Pattern.compile("\\(([^\\)(]+)\\)");
        Matcher matcher = parentheses.matcher(inputString);

        while (matcher.find()) {
            String groupString = matcher.group();

            String groupStringNoParentheses = groupString.substring(1, groupString.length()-1);
            String groupResult = processWeirdMathString(groupStringNoParentheses);

            inputString = inputString.replace(groupString, groupResult);
        }

         return inputString;
    }

    static String processWeirdMathString(String mathString) {
        String[] splitString = mathString.split(" ");

        for (int i = 0; i < splitString.length -2; i += 2) {

            long firstNumber = Long.parseLong(splitString[i]);
            long secondNumber = Long.parseLong(splitString[i+2]);
            String operand = splitString[i+1];

            long result = operand.equals("+")? firstNumber + secondNumber : firstNumber * secondNumber;

            splitString[i+2] = Long.toString(result);
        }

        return splitString[splitString.length-1];
    }
}
