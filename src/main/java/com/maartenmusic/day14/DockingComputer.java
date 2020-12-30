package com.maartenmusic.day14;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@NoArgsConstructor
public class DockingComputer {
    private List<DockingInstruction> instructions;
    private BitMask bitMask;
    private Map<Integer, Long> memory = new HashMap<>();

    public DockingComputer(List<DockingInstruction> instructions) {
        this.instructions = instructions;
    }

    public Long getSumOfMemory() {

        return memory.values().stream().reduce(Long::sum).orElse(-1L);
    }

}
