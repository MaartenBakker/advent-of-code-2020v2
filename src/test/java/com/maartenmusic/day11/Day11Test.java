package com.maartenmusic.day11;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.File;

class Day11Test {

    @Test
    void occupiedSeatsAtFinalState() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom2dList seatingRoom2dList = FileReaders.txtToSeatingRoom2dList(txtFile);

        assertEquals(37, Day11.occupiedSeatsAtFinalState2dList(seatingRoom2dList));

        SeatingRoomMap seatingRoomMap = FileReaders.txtToSeatingRoomMap(txtFile);

        assertEquals(37, Day11.occupiedSeatsAtFinalStateMap(seatingRoomMap));

    }



}