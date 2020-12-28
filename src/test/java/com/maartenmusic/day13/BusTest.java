package com.maartenmusic.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    @Test
    void arrivesOn() {
        Bus bus1 = new Bus(7, 0);
        assertTrue(bus1.matchesRequirement(7));
        assertTrue(bus1.matchesRequirement(14));
        assertFalse(bus1.matchesRequirement(8));

        Bus bus2 = new Bus(8, 1);
        assertTrue(bus1.matchesRequirement(7));
    }
}