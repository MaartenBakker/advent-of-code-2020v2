package com.maartenmusic.day17;

import com.maartenmusic.util.Coordinates3D;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ConwayCube {
    private final Coordinates3D coordinates3D;
    private final List<ConwayCube> neighbours = new ArrayList<>();

    public ConwayCube(Coordinates3D coordinates3D) {
        this.coordinates3D = coordinates3D;
    }

    public void findNeighbours() {
        neighbours.clear();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1 ; y++) {
                for (int z = -1; z <= 1; z++) {
                    neighbours.add(
                            new ConwayCube(
                                    new Coordinates3D(
                                            this.coordinates3D.getX() + x,
                                            this.coordinates3D.getY() + y,
                                            this.coordinates3D.getZ() + z
                                    )
                            )
                    );
                }
            }
        }
        neighbours.remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConwayCube)) return false;

        ConwayCube that = (ConwayCube) o;

        return coordinates3D.equals(that.coordinates3D);
    }

    @Override
    public int hashCode() {
        return coordinates3D.hashCode();
    }

    @Override
    public String toString() {
        return "ConwayCube{" +
                "coordinates3D=" + coordinates3D +
                '}';
    }
}
