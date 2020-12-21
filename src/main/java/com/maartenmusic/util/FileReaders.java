package com.maartenmusic.util;

import com.maartenmusic.day11.SeatSpace;
import com.maartenmusic.day11.SeatingRoom;
import com.maartenmusic.day4.Passport;
import com.maartenmusic.day8.Instruction;
import com.maartenmusic.day8.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class FileReaders {


    public static List<Instruction> txtToInstructions(File file) {
        List<Instruction> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                String[] splitLine = line.split(" ");
                String operationString = splitLine[0];

                Operation operation;

                switch(operationString) {
                    case "acc": operation = Operation.ACC;
                        break;
                    case "jmp": operation = Operation.JMP;
                        break;
                    case "nop": operation = Operation.NOP;
                        break;
                    default: operation = Operation.NOP;
                }

                int argument = Integer.parseInt(splitLine[1]);

                instructions.add(new Instruction(operation, argument));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return instructions;
    }

    public static Map<String, Map<String, Integer>> txtToColorAndAmountMap(File file) {
        Map<String, Map<String, Integer>> bagMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                String[] splitLine = line.split("contain");
                String[] bagColor = splitLine[0].split(" ");
                String bag = bagColor[0] + bagColor[1];

                Map<String, Integer> bagAmountMap = new HashMap<>();
                String[] colors = splitLine[1].split(",");
                for(String color: colors) {
                    String[] splitColor = color.split(" ");

                    if(!splitColor[1].equals("no")) {
                        bagAmountMap.put(splitColor[2] + splitColor[3]
                                , Integer.parseInt(splitColor[1]));
                    }
                }

                bagMap.put(bag, bagAmountMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bagMap;
    }

    public static Map<String, ArrayList<String>> txtToBagAndColorsMap(File file) {
        Map<String, ArrayList<String>> bagMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                String[] splitLine = line.split("contain");
                String[] bagColor = splitLine[0].split(" ");
                String bag = bagColor[0] + bagColor[1];

                ArrayList<String> colorList = new ArrayList<>();
                String[] colors = splitLine[1].split(",");
                for(String color: colors) {
                    String[] splitColor = color.split(" ");
                    colorList.add(splitColor[2] + splitColor[3]);
                }

                bagMap.put(bag, colorList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bagMap;
    }

    public static List<Long> txtToLongs(File file) {

        List<Long> longList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                longList.add(Long.parseLong(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return longList;
    }

    public static List<Integer> txtToIntegers(File file) {

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

    public static List<String> txtToStrings(File file) {

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

    public static SeatingRoom txtToSeatingRoom(File file) {
        List<List<SeatSpace>> seatSpaces = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                List<SeatSpace> currentRow =  new ArrayList<>();

                List<String> chars = Arrays.asList(line.split(""));
                chars.forEach(character -> currentRow.add(new SeatSpace(character)));

                seatSpaces.add(currentRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SeatingRoom(seatSpaces);

    }


    public static List<List<String>> alineasToStrings2d(File file) {
        List<List<String>> theMatrix = new ArrayList<>();
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

    public static ArrayList<Passport> txtToPassports(File file) {
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
