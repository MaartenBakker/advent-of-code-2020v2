package com.maartenmusic.day17;

import com.maartenmusic.util.Coordinates4D;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ConwayHyperCube implements Cube {
    private final Coordinates4D coordinates4D;
    private final List<Cube> neighbours = new ArrayList<>();

    public ConwayHyperCube(Coordinates4D coordinates4D) {
        this.coordinates4D = coordinates4D;
    }

    @Override
    public void findNeighbours() {
        neighbours.clear();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1 ; y++) {
                for (int z = -1; z <= 1; z++) {
                    for (int w = -1; w <= 1 ; w++) {
                        neighbours.add(
                                new ConwayHyperCube(
                                        new Coordinates4D(
                                                this.coordinates4D.getX() + x,
                                                this.coordinates4D.getY() + y,
                                                this.coordinates4D.getZ() + z,
                                                this.coordinates4D.getW() + w
                                        )
                                )
                        );
                    }
                }
            }
        }
        neighbours.remove(this);
    }

    @Override
    public String toString() {
        return "ConwayHyperCube{" +
                "coordinates4D=" + coordinates4D +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConwayHyperCube)) return false;

        ConwayHyperCube that = (ConwayHyperCube) o;

        return coordinates4D.equals(that.coordinates4D);
    }

    @Override
    public int hashCode() {
        return coordinates4D.hashCode();
    }
}
