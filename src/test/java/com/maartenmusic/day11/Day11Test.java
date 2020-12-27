package com.maartenmusic.day11;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.File;

class Day11Test {

    @Test
    void occupiedSeatsAtFinalState() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom2dList seatingRoom2dList = TxtFileReaders.toSeatingRoom2dList(txtFile);

        assertEquals(37, Day11.occupiedSeatsAtFinalState2dList(seatingRoom2dList));

        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);

        assertEquals(37, Day11.occupiedSeatsAtFinalStateMapPart1(seatingRoomMap));

    }

    @Test
    void occupiedSeatsAtFinalStateMapPart2() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);

        assertEquals(26, Day11.occupiedSeatsAtFinalStateMapPart2(seatingRoomMap));
    }
}