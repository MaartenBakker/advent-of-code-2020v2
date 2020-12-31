package com.maartenmusic.day14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DockingComputerTest {

    @Test
    void getSumOfMemory() {
        DockingComputer dockingComputer = new DockingComputer();
        Map<Long, Long> memory = new HashMap<>();

        memory.put(0L, 10L);
        memory.put(1L, 15L);
        memory.put(0L, 5L); // to check if overwrites work
        memory.put(10000L, 5555555L);

        dockingComputer.setMemory(memory);

        assertEquals(5555575L, dockingComputer.getSumOfMemory());
    }

    @Test
    void getIndexesOfX() {
        String bitsWithX = "AAXXbbXX";
        DockingComputer dockingComputer = new DockingComputer();
        assertEquals(Arrays.asList(2,3,6,7), dockingComputer.getIndexesOfX(bitsWithX));
    }

    @Test
    void getBitsWithX() {
        BitMask bitMask = new BitMask("000000000000000000000000000000X1001X");
        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.setBitMask(bitMask);

        String bitAddress = "000000000000000000000000000000000000";
        assertEquals("000000000000000000000000000000X1001X",
                dockingComputer.getBitsWithX(bitAddress));

        bitAddress = "111111111111111111111111111111111101";
        assertEquals("111111111111111111111111111111X1111X",
                dockingComputer.getBitsWithX(bitAddress));
    }
}