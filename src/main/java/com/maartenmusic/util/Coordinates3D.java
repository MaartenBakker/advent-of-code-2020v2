package com.maartenmusic.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Coordinates3D  {
    private final int x;
    private final int y;
    private final int z;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates3D)) return false;

        Coordinates3D that = (Coordinates3D) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
