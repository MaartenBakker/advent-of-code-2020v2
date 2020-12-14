package com.maartenmusic.day8;

import lombok.Getter;

@Getter
public class EndOfInstructionsException extends RuntimeException {
    private final int accumulator;

    public EndOfInstructionsException(int accumulator) {
        this.accumulator = accumulator;
    }
}
