package com.maartenmusic.day14;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day14 {

    public static void main(String[] args) {

        File txtFile = new File(FilePathGenerator.getFilePath("day14"));
        System.out.println(getResultOfPart1(txtFile));
        System.out.println(getResultOfPart2(txtFile));

//        Part 2
//
//        X Load data
//        dockingComputer.followInstructionsV2
//          - read instructions
//          - if getClass(instruction).equals(BitMask.class) zelfde als v1
//          - if MemoryInstruction.class ->
//             * - apply mask -> List of memoryAdresses
//              - save MemoryInstruction.value to every address
//
//          *   X vertaal MemoryInstruction naar 36 bit
//              X new StringBuilder
//              X iterate over chars of bitAddress en Mask
//              X '0' -> sb.add char uit bitAddress
//              X '1' || 'X' -> sb.add char uit Mask
//              X String bitsWithX = sb.toString();
//
//              X List<Integer> indexesOfX;
//
//              X List<String> allPermutations(List<String> permutations)
//              X allPermutations.add(bitsWithX);
//
//              X for i < indexesOfX.size() {
//
//              X List<String> nextPermutations = new ArrayList<String>
//              X for (String permutation : permutations) {
//
//
//              X maak kopie van bitsWithX;
//              X vervang eerste charAt(indexesOfX.get(i)) met 0, -> add to nextPermutations
//              X vervang eerste charAt(indexesOfX.get(i)) met 1, -> add to nextPermutations;
//
//              X allPermutations = nextPermutations
//
//              }


    }

    static Long getResultOfPart2(File txtFile) {
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructionsV2(instructions);

        return dockingComputer.getSumOfMemory();
    }

    static Long getResultOfPart1(File txtFile) {
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructions(instructions);

        return dockingComputer.getSumOfMemory();
    }
}
