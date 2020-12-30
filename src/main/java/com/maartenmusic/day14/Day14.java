package com.maartenmusic.day14;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day14 {

    public static void main(String[] args) {
//        X read data into list<DockingInstruction>
//        X abstract class DockingInstruction
//        X class MemoryInstruction heeft address en value
//        X class BitMask heeft mask;
//        X class DockingComputer heeft List<DockingInstruction> instructions
//        X heeft BitMask bitMask
//        X heeft Map<address, value> memory
//        method followInstructions()
//            X - lees eerstvolgende DockingInstruction van instructions
//            X - if getClass(BitMask) -> this.bitMask = BitMask
//            - if MemoryInstruction -> X - vertaal value naar 36 bits bitValue
//                                      X - bewerk met this.bitMask ( maskedBitValue = bitMask.mask(value) ?)
//                                      X - vertaal terug naar Long. maskedLongValue
//                                      X - sla op: memory.put(MemoryInstruction.getAddress, maskedValue)
//        X getSumOfMemory = memory.values().stream().reduce(Integer::Sum);
//
//        X Class 36BitConverter?? Integer.toBinaryString(int num)

        File txtFile = new File(FilePathGenerator.getFilePath("day14"));
        System.out.println(getResultOfPart1(txtFile));
    }

    static Long getResultOfPart1(File txtFile) {
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructions(instructions);

        return dockingComputer.getSumOfMemory();
    }
}
