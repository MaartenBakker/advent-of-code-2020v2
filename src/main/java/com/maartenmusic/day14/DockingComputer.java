package com.maartenmusic.day14;

import java.util.List;

public class DockingComputer {
    private final List<DockingInstruction> instructions;
    private BitMask bitMask;

    public DockingComputer(List<DockingInstruction> instructions) {
        this.instructions = instructions;
    }
}
