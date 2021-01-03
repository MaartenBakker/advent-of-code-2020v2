package com.maartenmusic.day16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
public class Rule {
    @Getter
    private final String name;
    private final List<Range> ranges;

    public boolean isValid(int number) {
        return ranges.stream().anyMatch(range -> range.isValid(number));
    }
}
