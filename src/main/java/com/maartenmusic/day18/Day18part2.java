package com.maartenmusic.day18;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day18part2 {

    public static void main(String[] args) {

        File file = new File(FilePathGenerator.generate("day18"));
        List<String> inputStrings = TxtFileReaders.toStrings(file);
        System.out.println(
                inputStrings.stream()
                .map(Day18part2::processInputString)
                .map(Long::parseLong)
                .reduce(Long::sum)
        );
    }

    static String processInputString(String inputString) {
        while (inputString.contains("(")) {
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

    static String processPluses(String inputString) {
        Pattern parentheses = Pattern.compile("\\d+ \\+ \\d+");
        Matcher matcher = parentheses.matcher(inputString);

        while (matcher.find()) {
            String groupString = matcher.group();
            String groupResult = processWeirdMathStringPluses(groupString);

            inputString = inputString.replaceFirst(Pattern.quote(groupString), groupResult);
        }

        return inputString;
    }

    static String processWeirdMathString(String mathString) {
        while (mathString.contains("+")) {
            mathString = processPluses(mathString);
        }

        String[] splitString = mathString.split(" ");

        for (int i = 0; i < splitString.length -2; i += 2) {

            long firstNumber = Long.parseLong(splitString[i]);
            long secondNumber = Long.parseLong(splitString[i+2]);

            long result = firstNumber * secondNumber;

            splitString[i+2] = Long.toString(result);
        }

        return splitString[splitString.length-1];
    }

    static String processWeirdMathStringPluses(String mathString) {
        String[] splitString = mathString.split(" ");

        long result = Long.parseLong(splitString[0]) + Long.parseLong(splitString[2]);

        return Long.toString(result);
    }
}
