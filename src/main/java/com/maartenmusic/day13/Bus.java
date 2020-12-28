package com.maartenmusic.day13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Bus implements Comparable<Bus>{
    private final long id;
    private final long offSet;

    public boolean matchesRequirement(long timeStamp) {
        return (timeStamp + offSet) % id == 0;
    }

    @Override
    public int compareTo(Bus o) {
        return Long.compare(this.id, o.id);
    }
}
