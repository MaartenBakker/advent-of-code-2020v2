package com.maartenmusic.day16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@Getter
public class Ticket {
    private final List<Integer> fields;
}
