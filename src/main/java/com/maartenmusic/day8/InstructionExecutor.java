package com.maartenmusic.day8;

import java.util.List;

public class InstructionExecutor {
    private final List<Instruction> instructions;
    private int accumulator = 0;

    public InstructionExecutor(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int execute(int position) throws EndOfInstructionsException, InstructionAboutToBeExecutedTwiceException {
        if (position == this.instructions.size()) {
            throw new EndOfInstructionsException(this.accumulator);
        }

        Instruction instruction = this.instructions.get(position);

        instruction.setExecutionCount(instruction.getExecutionCount() + 1);

        if(instruction.getExecutionCount() > 1) {
            throw new InstructionAboutToBeExecutedTwiceException(this.accumulator);
        }

        else if(instruction.getOperation() == Operation.ACC) {
            this.accumulator += instruction.getArgument();
            return execute(position + 1);
        }

        else if(instruction.getOperation() == Operation.JMP) {
            return execute(position + instruction.getArgument());
        }

        else if(instruction.getOperation() == Operation.NOP) {
            return execute(position + 1);
        }

        return -1; //should never be reached...
    }
}
