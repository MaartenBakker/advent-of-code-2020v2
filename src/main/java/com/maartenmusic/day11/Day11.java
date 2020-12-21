package com.maartenmusic.day11;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;

public class Day11 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day11"));
        SeatingRoom seatingRoom = FileReaders.txtToSeatingRoom(txtFile);

        System.out.println(occupiedSeatsAtFinalState(seatingRoom));
    }

    static int occupiedSeatsAtFinalState(SeatingRoom seatingRoom) {
        return -1;
    }
}
