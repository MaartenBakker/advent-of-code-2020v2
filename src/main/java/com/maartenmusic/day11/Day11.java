package com.maartenmusic.day11;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.Arrays;

public class Day11 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day11"));
        SeatingRoom seatingRoom = FileReaders.txtToSeatingRoom(txtFile);

        System.out.println(occupiedSeatsAtFinalState(seatingRoom));
    }

    static long occupiedSeatsAtFinalState(SeatingRoom oldSeatingRoom) {
        SeatingRoom newSeatingRoom = oldSeatingRoom.changeSeats();

            if(newSeatingRoom.flattenSeats().equals(oldSeatingRoom.flattenSeats())) {
                return Arrays.stream(newSeatingRoom.flattenSeats().split(""))
                        .filter(character -> character.equals("#")).count();
            }

            return occupiedSeatsAtFinalState(newSeatingRoom);
    }
}
