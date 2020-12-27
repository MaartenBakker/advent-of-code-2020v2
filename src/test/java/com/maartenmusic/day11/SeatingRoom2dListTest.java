package com.maartenmusic.day11;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;

class SeatingRoom2dListTest {

    @Test
    void changeSeats() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom2dList seatingRoom2dList = TxtFileReaders.toSeatingRoom2dList(txtFile);
        SeatingRoom2dList newSeatingRoom2dList = seatingRoom2dList.changeSeats();

        newSeatingRoom2dList.getSeatSpaces().forEach(System.out::println);
    }
}