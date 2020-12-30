package com.maartenmusic.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitMaskTest {

    @Test
    void getMaskedString() {
        BitMask bit36Mask = new BitMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");

        assertEquals("000000000000000000000000000001001001",
                bit36Mask.getMaskedString("000000000000000000000000000000001011"));
    }
}