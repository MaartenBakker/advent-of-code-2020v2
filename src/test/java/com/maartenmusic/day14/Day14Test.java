package com.maartenmusic.day14;

import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

    @Test
    void getResultOfPart2() {
        File txtFile = new File("src/test/java/com/maartenmusic/day14/testInput2.txt");
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructionsV2(instructions);

        assertEquals(208, dockingComputer.getSumOfMemory());

    }

    @Test
    void getResultOfPart1() {
        File txtFile = new File("src/test/java/com/maartenmusic/day14/testInput.txt");
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructions(instructions);

        assertEquals(165, dockingComputer.getSumOfMemory());
    }
}