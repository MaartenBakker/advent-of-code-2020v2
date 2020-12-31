package com.maartenmusic.day14;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
public class DockingComputer {
    private BitMask bitMask;
    private Map<Long, Long> memory = new HashMap<>();

    public Long getSumOfMemory() {

        return memory.values().stream().reduce(Long::sum).orElse(-1L);
    }

    public void followInstructionsV2(List<DockingInstruction> instructions) {
        for (DockingInstruction instruction : instructions) {
            if (instruction.getClass().equals(BitMask.class)) {

                this.bitMask = (BitMask) instruction;

            } else if (instruction.getClass().equals(MemoryInstruction.class))  {

                handleMemoryInstructionV2((MemoryInstruction) instruction);
            }
        }
    }

    public void followInstructions(List<DockingInstruction> instructions) {

        for (DockingInstruction instruction : instructions) {
            if (instruction.getClass().equals(BitMask.class)) {

                this.bitMask = (BitMask) instruction;

            } else if (instruction.getClass().equals(MemoryInstruction.class))  {

                handleMemoryInstruction((MemoryInstruction) instruction);
            }
        }
    }

    void handleMemoryInstruction(MemoryInstruction instruction) {
        String bit36 = Converter36Bit.to36BitString(instruction.getValue());
        String maskedBits = bitMask.getMaskedString(bit36);
        Long convertedNumber = Long.parseLong(maskedBits, 2);

        memory.put((long) instruction.getAddress(), convertedNumber);
    }

    void handleMemoryInstructionV2(MemoryInstruction instruction) {
        List<String> addresses = getAllAdresses(instruction);
        List<Long> longAddresses = addresses.stream()
                .map(string -> Long.parseLong(string, 2))
                .collect(Collectors.toList());
        longAddresses.forEach(address -> memory.put(address, instruction.getValue()));
    }

    List<String> getAllAdresses(MemoryInstruction instruction) {
        String bitAddress = Converter36Bit.to36BitString((long) instruction.getAddress());

//        first build string with 1 and 0 from mask handled, X's put in place
        String bitsWithX = getBitsWithX(bitAddress);

        List<Integer> indexesOfX = getIndexesOfX(bitsWithX);

        List<String> allPermutations = new ArrayList<>();

//        add the starting point
        allPermutations.add(bitsWithX);

//        for each X, get two versions (with 0 and 1), and add them to List.
//        repeat this for next X for each item in growing list
        for (Integer indexOfX : indexesOfX) {
            List<String> newPermutations = new ArrayList<>();

            for (String permutation : allPermutations) {
                StringBuilder sb0 = new StringBuilder(permutation);
                StringBuilder sb1 = new StringBuilder(permutation);

                sb0.setCharAt(indexOfX, '0');
                sb1.setCharAt(indexOfX, '1');

                newPermutations.add(sb0.toString());
                newPermutations.add(sb1.toString());

                allPermutations = newPermutations;
            }

        }
        return allPermutations;

    }

    List<Integer> getIndexesOfX(String bitsWithX) {
        List<Integer> indexesOfX = new ArrayList<>();

        for (int i = 0; i < bitsWithX.length(); i++) {
            if(bitsWithX.charAt(i) == 'X') {
                indexesOfX.add(i);
            }
        }

        return indexesOfX;
    }

    String getBitsWithX(String bitAddress) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bitAddress.length(); i++) {
            char maskCharacter = bitMask.getMask().charAt(i);

            if (maskCharacter == '0') {
                sb.append(bitAddress.charAt(i));
            } else {
                sb.append((bitMask.getMask().charAt(i)));
            }
        }

        return sb.toString();
    }
}
