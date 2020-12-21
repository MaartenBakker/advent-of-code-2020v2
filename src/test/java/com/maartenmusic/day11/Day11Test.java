package com.maartenmusic.day11;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.File;
import java.util.List;

class Day11Test {

    @Test
    void occupiedSeatsAtFinalState() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput.txt");
        SeatingRoom seatingRoom = FileReaders.txtToSeatingRoom(txtFile);

        assertEquals(37, Day11.occupiedSeatsAtFinalState(seatingRoom));

    }



}