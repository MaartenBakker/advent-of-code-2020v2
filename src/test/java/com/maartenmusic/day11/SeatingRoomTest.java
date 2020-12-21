package com.maartenmusic.day11;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SeatingRoomTest {

    @Test
    void changeSeats() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom seatingRoom = FileReaders.txtToSeatingRoom(txtFile);
        SeatingRoom newSeatingRoom = seatingRoom.changeSeats();

        newSeatingRoom.getSeatSpaces().forEach(System.out::println);
    }
}