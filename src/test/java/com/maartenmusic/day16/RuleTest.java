package com.maartenmusic.day16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    void isValid() {
        Range range1 = new Range(1,5);
        Range range2 = new Range(8,12);
        List<Range> ranges = Arrays.asList(range1, range2);

        Rule rule = new Rule("testRule", ranges);

        assertTrue(rule.isValid(1));
        assertTrue(rule.isValid(3));
        assertTrue(rule.isValid(5));
        assertTrue(rule.isValid(8));
        assertTrue(rule.isValid(9));
        assertTrue(rule.isValid(12));

        assertFalse(rule.isValid(0));
        assertFalse(rule.isValid(6));
        assertFalse(rule.isValid(13));
    }
}