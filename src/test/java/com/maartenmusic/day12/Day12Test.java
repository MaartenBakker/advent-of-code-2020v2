package com.maartenmusic.day12;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day12Test {

    @Test
            void getResultPart1() {
        File file = new File("src/test/java/com/maartenmusic/day12/testInput.txt");
        List<Action> actions = TxtFileReaders.toActions(file);

        Ship ship = new Ship();
        ship.followActions(actions);
        assertEquals(ship.getCoordinates().manhattanDistance(), 25);
    }


}