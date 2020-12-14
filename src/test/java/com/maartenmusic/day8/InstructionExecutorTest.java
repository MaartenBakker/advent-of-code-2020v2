package com.maartenmusic.day8;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionExecutorTest {

    @Test
    void execute() {
        File txtFile = new File("src/main/java/com/maartenmusic/day8/testInput.txt");

        List<Instruction> instructions = FileReaders.readTxtFileIntoListOfInstructions(txtFile);
        InstructionExecutor instructionExecutor = new InstructionExecutor(instructions);

        assertEquals(5, instructionExecutor.returnAccOnRepeatedInstruction(0));
    }
}