package com.maartenmusic.day14;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DockingComputerTest {

    @Test
    void getSumOfMemory() {
        DockingComputer dockingComputer = new DockingComputer();
        Map<Integer, Long> memory = new HashMap<>();

        memory.put(0, 10L);
        memory.put(1, 15L);
        memory.put(0, 5L); // checking for overwrites
        memory.put(10000, 5555555L);

        dockingComputer.setMemory(memory);

        assertEquals(5555575L, dockingComputer.getSumOfMemory());
    }
}