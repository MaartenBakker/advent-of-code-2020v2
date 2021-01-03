package com.maartenmusic.day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void isValid() {
        Range range = new Range(5,10);
        assertTrue(range.isValid(5));
        assertTrue(range.isValid(10));
        assertTrue(range.isValid(7));

        assertFalse(range.isValid(4));
        assertFalse(range.isValid(11));
    }
}