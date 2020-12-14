package com.maartenmusic.day8;

import lombok.Getter;

@Getter
public class InstructionAboutToBeExecutedTwiceException extends RuntimeException{

    private final int accumulator;

    public InstructionAboutToBeExecutedTwiceException(int accumulator) {
        this.accumulator = accumulator;
    }
}
