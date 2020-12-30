package com.maartenmusic.day14;

public class Day14 {

    public static void main(String[] args) {
//        read data into list<DockingInstruction>
//        abstract class DockingInstruction
//        class MemoryInstruction heeft address en value
//        class BitMask heeft mask;
//        class DockingComputer heeft List<DockingInstruction> instructions
//        heeft BitMask bitMask
//        heeft Map<address, value> memory
//        method followInstructions()
//            - lees eerstvolgende DockingInstruction van instructions
//            - if getClass(BitMask) -> this.bitMask = BitMask
//            - if MemoryInstruction -> - vertaal value naar 36 bits bitValue
//                                      - bewerk met this.bitMask ( maskedBitValue = bitMask.mask(value) ?)
//                                      - vertaal terug naar int. maskedIntValue
//                                      - sla op: memory.put(MemoryInstruction.getAddress, maskedValue)
//        memory.values().stream().reduce(Integer::Sum);
//
//        Class 36BitConverter?? Integer.toBinaryString(int num)

    }
}
