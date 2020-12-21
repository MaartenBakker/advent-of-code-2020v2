package com.maartenmusic.util;

import com.maartenmusic.day11.SeatSpace;
import com.maartenmusic.day11.SeatingRoom;
import com.maartenmusic.day8.Instruction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FileReadersTest {

    @Test
    void txtToInstructions() {
        File txtFile = new File("src/main/java/com/maartenmusic/day8/testInput.txt");

        List<Instruction> instructions = FileReaders.txtToInstructions(txtFile);

        instructions.forEach(instruction -> {
            System.out.println(instruction.getOperation());
            System.out.println(instruction.getArgument());

        });
    }

    @Test
    void txtToBagAndColorsMap() {

        File txtFile = new File(FilePathGenerator.getFilePath("day7"));

        Map<String, ArrayList<String>> rules = FileReaders.txtToBagAndColorsMap(txtFile);

        rules.keySet().stream().sorted().forEach(System.out::println);
        rules.values().forEach(System.out::println);
    }

    @Test
    void txtToColorAndAmountMap() {

        File txtFile = new File(FilePathGenerator.getFilePath("day7"));
        Map<String, Map<String, Integer>> rules = FileReaders.txtToColorAndAmountMap(txtFile);

//        rules.keySet().stream().sorted().forEach(System.out::println);
        rules.values().forEach(list -> {
            for (Map.Entry<String, Integer> colorAmounts : list.entrySet()) {
                System.out.println(colorAmounts.getKey() + " " + colorAmounts.getValue());
            }
        });

    }

    @Test
    void txtToSeatSpaces() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom seatingRoom = FileReaders.txtToSeatingRoom(txtFile);
        seatingRoom.getSeatSpaces().forEach(System.out::println);
    }
}