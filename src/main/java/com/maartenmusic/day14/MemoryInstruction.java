package com.maartenmusic.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class MemoryInstruction extends DockingInstruction {
    private final int address;
    private final int value;
}
