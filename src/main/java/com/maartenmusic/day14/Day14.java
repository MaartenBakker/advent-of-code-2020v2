package com.maartenmusic.day14;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day14 {

    public static void main(String[] args) {

        File txtFile = new File(FilePathGenerator.getFilePath("day14"));
        System.out.println(getResultOfPart1(txtFile));

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
//          *   vertaal MemoryInstruction naar 36 bit
//              new StringBuilder
//              iterate over chars of MemoryInstruction en Mask
//              '0' -> sb.add char uit MemoryInstruction
//              '1' || 'X' -> sb.add char uit Mask
//              String startingBits = sb.toString();
//
//              List<Integer> indexesOfX;
//
//              List<String> allPermutations(List<String> permutations)
//              allPermutations.add(startingBits);
//
//              for i < indexesOfX.size() {
//
//              List<String> nextPermutations = new ArrayList<String>
//              for (String permutation : permutations) {
//
//
//              maak kopie van startingBits;
//              vervang eerste charAt(i) met 0, -> add to nextPermutations
//              vervang eerste charAt(i) met 1, -> add to nextPermutations;
//
//              allPermutations = nextPermutations
//
//              }


    }

    static Long getResultOfPart1(File txtFile) {
        List<DockingInstruction> instructions = TxtFileReaders.toDockingInstructions(txtFile);

        DockingComputer dockingComputer = new DockingComputer();
        dockingComputer.followInstructions(instructions);

        return dockingComputer.getSumOfMemory();
    }
}
