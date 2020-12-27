package com.maartenmusic.day8;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day8 {
    private static int listIndex;

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day8"));

        printSolutionPart1(txtFile);

        //Solution part 2
        System.out.println(getAccAtEndOfInstructions(txtFile));

    }

    private static int getAccAtEndOfInstructions(File txtFile) {
         List<Instruction> instructions = TxtFileReaders.toInstructions(txtFile);

        while(true) {
            InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

            try {
                instructionExecutor.execute(0);
            } catch (InstructionAboutToBeExecutedTwiceException e) {
                instructions = TxtFileReaders.toInstructions(txtFile);
                changeInstructions(instructions);
            } catch (EndOfInstructionsException e) {
                return e.getAccumulator();
            }
        }
    }

    private static void changeInstructions(List<Instruction> instructions) {
        Instruction instruction = instructions.get(listIndex);

        if(instruction.getOperation() == Operation.NOP) {
            instruction.setOperation(Operation.JMP);
        } else if (instruction.getOperation() == Operation.JMP) {
            instruction.setOperation(Operation.NOP);
        }
        listIndex++;
    }

    private static void printSolutionPart1(File txtFile) {
        List<Instruction> instructions = TxtFileReaders.toInstructions(txtFile);

        InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

        try {
            instructionExecutor.execute(0);
        } catch (InstructionAboutToBeExecutedTwiceException e) {
            System.out.println(e.getAccumulator());
        }
    }

}
