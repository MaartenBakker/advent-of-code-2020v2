package com.maartenmusic.day11;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.Arrays;

public class Day11 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.generate("day11"));

        long startList = System.nanoTime();
        SeatingRoom2dList seatingRoom2dList = TxtFileReaders.toSeatingRoom2dList(txtFile);

        System.out.println(occupiedSeatsAtFinalState2dList(seatingRoom2dList));
        long finishList = System.nanoTime();

        long startMap = System.nanoTime();
        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);

        System.out.println(occupiedSeatsAtFinalStateMapPart1(seatingRoomMap));
        long finishMap = System.nanoTime();

        System.out.println("List duration: " + (finishList - startList));
        System.out.println("Map duration: " + (finishMap - startMap));

        System.out.println("Solution part 2:");
        System.out.println(occupiedSeatsAtFinalStateMapPart2(seatingRoomMap));

    }

    static long occupiedSeatsAtFinalState2dList(SeatingRoom2dList oldSeatingRoom2dList) {
        SeatingRoom2dList newSeatingRoom2dList = oldSeatingRoom2dList.changeSeats();

            if(newSeatingRoom2dList.flattenSeats().equals(oldSeatingRoom2dList.flattenSeats())) {
                return Arrays.stream(newSeatingRoom2dList.flattenSeats().split(""))
                        .filter(character -> character.equals("#")).count();
            }

            return occupiedSeatsAtFinalState2dList(newSeatingRoom2dList);
    }

    static long occupiedSeatsAtFinalStateMapPart1(SeatingRoomMap oldSeatingRoomMap) {
        SeatingRoomMap newSeatingRoomMap = oldSeatingRoomMap.changeSeatsPart1();

        if(newSeatingRoomMap.flattenSeats().equals(oldSeatingRoomMap.flattenSeats())) {
            return Arrays.stream(newSeatingRoomMap.flattenSeats().split(""))
                    .filter(character -> character.equals("#")).count();
        }

        return occupiedSeatsAtFinalStateMapPart1(newSeatingRoomMap);
    }

    static long occupiedSeatsAtFinalStateMapPart2(SeatingRoomMap oldSeatingRoomMap) {
        SeatingRoomMap newSeatingRoomMap = oldSeatingRoomMap.changeSeatsPart2();

        if(newSeatingRoomMap.flattenSeats().equals(oldSeatingRoomMap.flattenSeats())) {
            return Arrays.stream(newSeatingRoomMap.flattenSeats().split(""))
                    .filter(character -> character.equals("#")).count();
        }

        return occupiedSeatsAtFinalStateMapPart2(newSeatingRoomMap);
    }


}
