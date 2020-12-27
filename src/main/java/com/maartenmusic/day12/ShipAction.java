package com.maartenmusic.day12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class ShipAction {
    private final char type;
    private final int value;
}
