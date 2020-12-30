package com.maartenmusic.day14;

import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
public class DockingComputer {
    private BitMask bitMask;
    private Map<Integer, Long> memory = new HashMap<>();

    public Long getSumOfMemory() {

        return memory.values().stream().reduce(Long::sum).orElse(-1L);
    }

    public void followInstructions(List<DockingInstruction> instructions) {

        for (DockingInstruction instruction : instructions) {
            if (instruction.getClass().equals(BitMask.class)) {

                this.bitMask = (BitMask) instruction;

            } else if (instruction.getClass().equals(MemoryInstruction.class))  {

                handleMemoryInstruction((MemoryInstruction) instruction);
            }
        }
    }

    void handleMemoryInstruction(MemoryInstruction instruction) {
        String bit36 = Converter36Bit.to36BitString(instruction.getValue());
        String maskedBits = bitMask.getMaskedString(bit36);
        Long convertedNumber = Long.parseLong(maskedBits, 2);

        memory.put(instruction.getAddress(), convertedNumber);
    }

}
