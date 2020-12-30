package com.maartenmusic.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BitMask extends DockingInstruction {
    private final String mask;
    
    public String getMaskedString(String bits) {
        StringBuilder bitsString = new StringBuilder(bits);

        for (int i = 0; i < mask.length() ; i++) {
            if (mask.charAt(i) != 'X') {
                bitsString.setCharAt(i, mask.charAt(i));
            }
        }

        return bitsString.toString();
    }
}
