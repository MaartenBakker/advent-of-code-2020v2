package com.maartenmusic.day3;

import com.maartenmusic.util.Coordinates;
import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
//        readTextIntoArrayListOfStrings();
//        posx = 0;
//        posy = 0
//                while posy < arrayList.size;
//        arrayList.get(posy).charAt(posx);
//        checkIfHash();
//        countHashes();
//        posy = posy +1;
//        posx = posx + 3;
//        if (posx > string.length() - 1) {
//            posx = posx - string.length();
//        }
        File txtFile = new File(FilePathGenerator.getFilePath("day3"));
        List<String> data = FileReaders.txtToStrings(txtFile);

        int a = (countTrees(data, new Directions(1, 1)));
        int b = (countTrees(data, new Directions(3, 1)));
        int c = (countTrees(data, new Directions(5, 1)));
        int d = (countTrees(data, new Directions(7, 1)));
        int e = (countTrees(data, new Directions(1, 2)));

        long result = (long) a * b * c * d * e;

        System.out.println(result);
    }

    private static int countTrees(List<String> data, Directions directions) {
        Coordinates coordinates = new Coordinates();
        int counter = 0;

        while(coordinates.getY() < data.size()) {
            String line = data.get(coordinates.getY());
            char charToCheck = line.charAt(coordinates.getX());
            if(isHash(charToCheck)) {
                counter++;
            }
            coordinates.setX(coordinates.getX() + directions.getMoveRight());
            coordinates.setY(coordinates.getY() + directions.getMoveDown());

            checkAndCatchCrossRightBorder(coordinates, line);
        }

        return counter;
    }

    private static void checkAndCatchCrossRightBorder(Coordinates coordinates, String line) {
        if(coordinates.getX() > line.length() -1 ) {
            coordinates.setX(coordinates.getX() - line.length());
        }
    }

    private static boolean isHash(char charToCheck) {
        return charToCheck == '#';
    }
}
