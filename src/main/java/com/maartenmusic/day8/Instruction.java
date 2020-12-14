package com.maartenmusic.day8;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Instruction {
    @Setter
    private Operation operation;
    private final int argument;
    @Setter
    private int executionCount;

    public Instruction(Operation operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }
}
