package com.maartenmusic.day11;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.Arrays;

public class Day11 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day11"));

        long startList = System.nanoTime();
        SeatingRoom2dList seatingRoom2dList = FileReaders.txtToSeatingRoom2dList(txtFile);

        System.out.println(occupiedSeatsAtFinalState2dList(seatingRoom2dList));
        long finishList = System.nanoTime();

        long startMap = System.nanoTime();
        SeatingRoomMap seatingRoomMap = FileReaders.txtToSeatingRoomMap(txtFile);

        System.out.println(occupiedSeatsAtFinalStateMap(seatingRoomMap));
        long finishMap = System.nanoTime();

        System.out.println("List duration: " + (finishList - startList));
        System.out.println("Map duration: " + (finishMap - startMap));

    }

    static long occupiedSeatsAtFinalState2dList(SeatingRoom2dList oldSeatingRoom2dList) {
        SeatingRoom2dList newSeatingRoom2dList = oldSeatingRoom2dList.changeSeats();

            if(newSeatingRoom2dList.flattenSeats().equals(oldSeatingRoom2dList.flattenSeats())) {
                return Arrays.stream(newSeatingRoom2dList.flattenSeats().split(""))
                        .filter(character -> character.equals("#")).count();
            }

            return occupiedSeatsAtFinalState2dList(newSeatingRoom2dList);
    }

    static long occupiedSeatsAtFinalStateMap(SeatingRoomMap oldSeatingRoomMap) {
        SeatingRoomMap newSeatingRoomMap = oldSeatingRoomMap.changeSeats();

        if(newSeatingRoomMap.flattenSeats().equals(oldSeatingRoomMap.flattenSeats())) {
            return Arrays.stream(newSeatingRoomMap.flattenSeats().split(""))
                    .filter(character -> character.equals("#")).count();
        }

        return occupiedSeatsAtFinalStateMap(newSeatingRoomMap);
    }
}
