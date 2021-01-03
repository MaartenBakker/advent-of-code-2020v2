package com.maartenmusic.util;

import com.maartenmusic.day11.SeatingRoom2dList;
import com.maartenmusic.day11.SeatingRoomMap;
import com.maartenmusic.day12.ShipAction;
import com.maartenmusic.day13.Bus;
import com.maartenmusic.day14.DockingInstruction;
import com.maartenmusic.day16.Rule;
import com.maartenmusic.day16.Ticket;
import com.maartenmusic.day8.Instruction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TxtFileReadersTest {

    @Test
    void toInstructions() {
        File txtFile = new File("src/main/java/com/maartenmusic/day8/testInput.txt");

        List<Instruction> instructions = TxtFileReaders.toInstructions(txtFile);

        instructions.forEach(instruction -> {
            System.out.println(instruction.getOperation());
            System.out.println(instruction.getArgument());

        });
    }

    @Test
    void toBagAndColorsMap() {

        File txtFile = new File(FilePathGenerator.getFilePath("day7"));

        Map<String, ArrayList<String>> rules = TxtFileReaders.toBagAndColorsMap(txtFile);

        rules.keySet().stream().sorted().forEach(System.out::println);
        rules.values().forEach(System.out::println);
    }

    @Test
    void toColorAndAmountMap() {

        File txtFile = new File(FilePathGenerator.getFilePath("day7"));
        Map<String, Map<String, Integer>> rules = TxtFileReaders.toColorAndAmountMap(txtFile);

//        rules.keySet().stream().sorted().forEach(System.out::println);
        rules.values().forEach(list -> {
            for (Map.Entry<String, Integer> colorAmounts : list.entrySet()) {
                System.out.println(colorAmounts.getKey() + " " + colorAmounts.getValue());
            }
        });

    }

    @Test
    void toSeatingRoom2dList() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom2dList seatingRoom2dList = TxtFileReaders.toSeatingRoom2dList(txtFile);
        seatingRoom2dList.getSeatSpaces().forEach(System.out::println);
    }

    @Test
    void toSeatingRoomMap() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);
        System.out.println(seatingRoomMap.flattenSeats());
    }

    @Test
    void toActions() {
        File txtFile = new File("src/test/java/com/maartenmusic/day12/testInput.txt");
        List<ShipAction> shipActions = TxtFileReaders.toShipActions(txtFile);
        shipActions.forEach(System.out::println);
    }

    @Test
    void toTimeStamp() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        int timeStamp = TxtFileReaders.toTimeStamp(txtFile);
        System.out.println(timeStamp);
    }

    @Test
    void toBusIDs() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        List<Integer> busIDs = TxtFileReaders.toBusIDs(txtFile);
        busIDs.forEach(System.out::println);
    }

    @Test
    void toBusIdsAndIndex() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        Map<Integer, Integer> busIDsAndIndex = TxtFileReaders.toBusIdsAndIndex(txtFile);
        busIDsAndIndex.entrySet().forEach(System.out::println);
    }

    @Test
    void toBuses() {
        File txtFile = new File("src/test/java/com/maartenmusic/day13/testInput.txt");
        List<Bus> buses = TxtFileReaders.toBuses(txtFile);
        buses.forEach(System.out::println);
    }

    @Test
    void toDockingInstructions() {
        File txtFile = new File("src/test/java/com/maartenmusic/day14/testInput.txt");
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);
        instructions.forEach(System.out::println);
    }

    @Test
    void toTicket() {
        File txtFile = new File("src/main/java/com/maartenmusic/day16/inputMyTicket.txt");
        Ticket ticket = TxtFileReaders.toTicket(txtFile);
        System.out.println(ticket);
    }

    @Test
    void toTickets() {
        File txtFile = new File("src/main/java/com/maartenmusic/day16/inputNearbyTickets.txt");
        List<Ticket> tickets = TxtFileReaders.toTickets(txtFile);
        tickets.forEach(System.out::println);
    }

    @Test
    void toRules() {
        File txtFile = new File("src/main/java/com/maartenmusic/day16/inputRules.txt");
        List<Rule> rules = TxtFileReaders.toRules(txtFile);
        rules.forEach(System.out::println);
    }
}
