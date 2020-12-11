package com.maartenmusic.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPosTest {

    @Test
    void checkPositions() {
        PasswordPos passwordPos1 = new PasswordPos(1, 2, 'a', "abcd");
        PasswordPos passwordPos2 = new PasswordPos(1, 2, 'a', "bacd");
        PasswordPos passwordPos3 = new PasswordPos(1, 2, 'a', "aabc");

        assertTrue(passwordPos1.checkPositions());
        assertTrue(passwordPos2.checkPositions());
        assertFalse(passwordPos3.checkPositions());
    }
}