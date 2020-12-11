package com.maartenmusic.util;

import com.maartenmusic.day6.Passport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaders {

    public static List<Integer> readTxtFileIntoArrayListOfInteger(File file) {

        List<Integer> integerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return integerList;
    }

    public static List<String> readTxtFileIntoArrayListOfStrings(File file) {

        List<String> listOfStrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                listOfStrings.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfStrings;
    }

    public static ArrayList<ArrayList<String>> readTxtFileInto2dArrayList(File file) {
        ArrayList<ArrayList<String>> theMatrix = new ArrayList<>();
        theMatrix.add(new ArrayList<>());

        int counter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                if(line.isBlank()){
                    theMatrix.add(new ArrayList<>());
                    counter++;
                    continue;
                }

                theMatrix.get(counter).add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return theMatrix;
    }

    public static ArrayList<Passport> readTxtFileIntoArrayListOfPassports(File file) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Passport> passports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                sb.append(line);
                sb.append("\n");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] passportsRawData = sb.toString().split("\n\n");
        for (String rawData : passportsRawData) {
            rawData = rawData.replace("\n", " ");
            passports.add(new Passport(rawData));
        }

        return passports;
    }

}
