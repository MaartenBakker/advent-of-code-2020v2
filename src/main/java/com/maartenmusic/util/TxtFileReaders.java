package com.maartenmusic.util;

import com.maartenmusic.day11.SeatSpace;
import com.maartenmusic.day11.SeatingRoom2dList;
import com.maartenmusic.day11.SeatingRoomMap;
import com.maartenmusic.day12.ShipAction;
import com.maartenmusic.day13.Bus;
import com.maartenmusic.day14.BitMask;
import com.maartenmusic.day14.DockingInstruction;
import com.maartenmusic.day14.MemoryInstruction;
import com.maartenmusic.day16.Range;
import com.maartenmusic.day16.Rule;
import com.maartenmusic.day16.Ticket;
import com.maartenmusic.day4.Passport;
import com.maartenmusic.day8.Instruction;
import com.maartenmusic.day8.Operation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TxtFileReaders {


    public static List<Instruction> toInstructions(File file) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }

    public static Map<String, Map<String, Integer>> toColorAndAmountMap(File file) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bagMap;
    }

    public static Map<String, ArrayList<String>> toBagAndColorsMap(File file) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bagMap;
    }

    public static List<Long> toLongs(File file) {

        List<Long> longList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                longList.add(Long.parseLong(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return longList;
    }

    public static List<Integer> toIntegers(File file) {

        List<Integer> integerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return integerList;
    }

    public static List<String> toStrings(File file) {

        List<String> listOfStrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                listOfStrings.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfStrings;
    }

    public static SeatingRoomMap toSeatingRoomMap(File file) {
        Map<Coordinates, SeatSpace> seatSpaces = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int yCounter = 0;

            while((line = reader.readLine()) != null) {

                List<String> chars = Arrays.asList(line.split(""));
                for (int i = 0; i < chars.size(); i++) {
                    seatSpaces.put(new Coordinates(i, yCounter), new SeatSpace(chars.get(i)));
//                    System.out.println(i + " " + yCounter + " " + chars.get(i));
                }

                yCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SeatingRoomMap(seatSpaces);

    }

    public static SeatingRoom2dList toSeatingRoom2dList(File file) {
        List<List<SeatSpace>> seatSpaces = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                List<SeatSpace> currentRow =  new ArrayList<>();

                List<String> chars = Arrays.asList(line.split(""));
                chars.forEach(character -> currentRow.add(new SeatSpace(character)));

                seatSpaces.add(currentRow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SeatingRoom2dList(seatSpaces);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return theMatrix;
    }

    public static ArrayList<Passport> toPassports(File file) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Passport> passports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {

                sb.append(line);
                sb.append("\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] passportsRawData = sb.toString().split("\n\n");
        for (String rawData : passportsRawData) {
            rawData = rawData.replace("\n", " ");
            passports.add(new Passport(rawData));
        }

        return passports;
    }

    public static List<ShipAction> toShipActions(File file) {
        List<ShipAction> shipActions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ShipAction shipAction = new ShipAction(line.charAt(0), Integer.parseInt(line.substring(1)));
                shipActions.add(shipAction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return shipActions;
    }

    public static int toTimeStamp(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Integer> toBusIDs(File file) {
        List<Integer> busIDs = new ArrayList<>();
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); //skip first line;
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] splitLine = line.split(",");
        for (String character : splitLine) {
            if (!character.equals("x")) {
                busIDs.add(Integer.parseInt(character));
            }
        }

        return busIDs;
    }

    public static Map<Integer, Integer> toBusIdsAndIndex(File file) {
        Map<Integer, Integer> busIDsAndIndex = new HashMap<>();
        String line = "";


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); //skip first line;
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> splitLine = Arrays.asList(line.split(","));

        for (String character : splitLine) {
            if (!character.equals("x")) {
                busIDsAndIndex.put(Integer.parseInt(character), splitLine.indexOf(character));
            }
        }

        return busIDsAndIndex;
    }

    public static List<Bus> toBuses(File file) {
        List<Bus> buses = new ArrayList<>();
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); //skip first line;
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> splitLine = Arrays.asList(line.split(","));

        for (int i = 0; i < splitLine.size(); i++) {
            String character = splitLine.get(i);
            if(!character.equals("x")) {
                buses.add(new Bus(Long.parseLong(character), i));
            }
        }
        return buses;
    }

    public static List<DockingInstruction> toDockingInstructions(File file) {
        List<DockingInstruction> instructions = new ArrayList<>();
        String line = "";


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" = ");

                if (splitLine[0].equals("mask")) {
                    instructions.add(new BitMask(splitLine[1]));
                } else {
                    String memoryAddress = splitLine[0].substring(4, splitLine[0].length() - 1);
                    String memoryValue = splitLine[1];
                    instructions.add(new MemoryInstruction(Integer.parseInt(memoryAddress), Long.parseLong(memoryValue)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }

    public static Ticket toTicket(File file) {
        String line = "";
        Ticket ticket = new Ticket(null);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                List<Integer> fields = Arrays.stream(splitLine)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                ticket = new Ticket(fields);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    public static List<Ticket> toTickets(File file) {
        List<Ticket> tickets = new ArrayList<>();
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                List<Integer> fields = Arrays.stream(splitLine)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                Ticket ticket = new Ticket(fields);
                tickets.add(ticket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    public static List<Rule> toRules(File file) {
        List<Rule> rules = new ArrayList<>();
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(": ");
                String name = splitLine[0];

                String[] ranges = splitLine[1].split(" or ");
                String[] range1Strings = ranges[0].split("-");
                String[] range2Strings = ranges[1].split("-");

                Range range1 = new Range(Integer.parseInt(range1Strings[0])
                        , Integer.parseInt(range1Strings[1]));

                Range range2 = new Range(Integer.parseInt(range2Strings[0])
                        , Integer.parseInt(range2Strings[1]));

                rules.add(new Rule(name, Arrays.asList(range1, range2)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rules;
    }

}
