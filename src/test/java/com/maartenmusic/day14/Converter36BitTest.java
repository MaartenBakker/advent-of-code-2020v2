package com.maartenmusic.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Converter36BitTest {

    @Test
    void to36BitString() {
        assertEquals("000000000000000000000000000000000001", Converter36Bit.to36BitString(1L));
        assertEquals("000000000000000000000000000000000101", Converter36Bit.to36BitString(5L));
        assertEquals("000000000000000000000000000000001001", Converter36Bit.to36BitString(9L));
    }

    @Test
    void toBinaryString() {
        System.out.println(Long.toBinaryString(8L));
        System.out.println(Long.toBinaryString(6L));
        System.out.println(Long.toBinaryString(4L));
        System.out.println(Long.toBinaryString(4L));
        System.out.println(Long.toBinaryString(3L));
        System.out.println(Long.toBinaryString(2L));
        System.out.println(Long.toBinaryString(1L));
        System.out.println(Long.toBinaryString(0L));
    }
}