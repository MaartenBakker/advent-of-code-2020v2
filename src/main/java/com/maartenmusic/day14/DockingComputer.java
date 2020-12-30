package com.maartenmusic.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockingComputer {
    private final List<DockingInstruction> instructions;
    private BitMask bitMask;
    private final Map<Integer, Long> memory = new HashMap();

    public DockingComputer(List<DockingInstruction> instructions) {
        this.instructions = instructions;
    }
}
