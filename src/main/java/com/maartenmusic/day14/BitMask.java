package com.maartenmusic.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BitMask extends DockingInstruction {
    private final String mask;
}
