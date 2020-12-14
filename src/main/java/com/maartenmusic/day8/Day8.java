package com.maartenmusic.day8;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day8 {
    private static int listIndex;

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day8"));

        printSolutionPart1(txtFile);

        printSolutionPart2(txtFile);

    }

    private static void printSolutionPart2(File txtFile) {
         List<Instruction> instructions = FileReaders.readTxtFileIntoListOfInstructions(txtFile);

        while(true) {
            InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

            try {
                instructionExecutor.execute(0);
            } catch (InstructionAboutToBeExecutedTwiceException e) {
                instructions = FileReaders.readTxtFileIntoListOfInstructions(txtFile);
                changeInstructions(instructions);
            } catch (EndOfInstructionsException e) {
                System.out.println(e.getAccumulator());
                break;
            }
        }
    }

    private static void changeInstructions(List<Instruction> instructions) {
        Instruction instruction = instructions.get(listIndex);

        if(instructions.get(listIndex).getOperation() == Operation.NOP) {
            instruction.setOperation(Operation.JMP);
        } else if (instruction.getOperation() == Operation.JMP) {
            instruction.setOperation(Operation.NOP);
        }
        listIndex++;
    }

    private static void printSolutionPart1(File txtFile) {
        List<Instruction> instructions = FileReaders.readTxtFileIntoListOfInstructions(txtFile);

        InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

        try {
            instructionExecutor.execute(0);
        } catch (InstructionAboutToBeExecutedTwiceException e) {
            System.out.println(e.getAccumulator());
        }
    }

}
