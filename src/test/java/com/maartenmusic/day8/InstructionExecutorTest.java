package com.maartenmusic.day8;

import com.maartenmusic.util.FileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionExecutorTest {

    @Test
    void execute() {
        File txtFile = new File("src/test/java/com/maartenmusic/day8/testInput.txt");

        List<Instruction> instructions = FileReaders.txtToInstructions(txtFile);
        InstructionExecutor instructionExecutor1 = new InstructionExecutor(instructions);

        assertThrows(InstructionAboutToBeExecutedTwiceException.class, ()-> instructionExecutor1.execute(0));

        try {
            instructionExecutor1.execute(0);
        } catch (InstructionAboutToBeExecutedTwiceException e) {
            assertEquals(5, e.getAccumulator());
        }
    }
}