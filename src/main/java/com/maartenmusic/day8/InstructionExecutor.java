package com.maartenmusic.day8;

import java.util.List;

public class InstructionExecutor {
    private final List<Instruction> instructions;
    private int accumulator = 0;

    public InstructionExecutor(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int returnAccOnRepeatedInstruction(int position) {
        Instruction instruction = this.instructions.get(position);

        instruction.setExecutionCount(instruction.getExecutionCount() + 1);

        if(instruction.getExecutionCount() > 1) {
            return this.accumulator;
        }

        else if(instruction.getOperation() == Operation.ACC) {
            this.accumulator += instruction.getArgument();
            return returnAccOnRepeatedInstruction(position + 1);
        }

        else if(instruction.getOperation() == Operation.JMP) {
            return returnAccOnRepeatedInstruction(position + instruction.getArgument());
        }

        else if(instruction.getOperation() == Operation.NOP) {
            return returnAccOnRepeatedInstruction(position + 1);
        }

        return -1; //should never be reached...
    }
}
