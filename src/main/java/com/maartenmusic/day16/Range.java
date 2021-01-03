package com.maartenmusic.day16;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Range {
    private final int min;
    private final int max;

    public boolean isValid(int number) {
        return number >= min && number <= max;
    }
}
