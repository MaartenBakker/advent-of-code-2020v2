package com.maartenmusic.day8;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.List;

public class Day8 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day8"));

        List<Instruction> instructions = FileReaders.readTxtFileIntoListOfInstructions(txtFile);

        InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

        System.out.println(instructionExecutor.execute(0));

    }

}
