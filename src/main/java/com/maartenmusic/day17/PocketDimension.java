package com.maartenmusic.day17;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PocketDimension {
    @Getter
    private final List<Cube> activeCubes = new ArrayList<>();
    private final Set<Cube> potentialActives = new HashSet<>();
    private final List<Cube> toBeDeactivated = new ArrayList<>();
    private final List<Cube> toBeActivated = new ArrayList<>();

    public void addActiveCubes(List<Cube> conwayCubes) {
        this.activeCubes.addAll(conwayCubes);
    }

    public void changeState() {
        determinePotentialActives();
        determineActivations();
        determineDeactivations();
        processChanges();
        clearState();
    }


    private void determinePotentialActives() {
        for (Cube activeCube : activeCubes) {
            activeCube.findNeighbours();
            potentialActives.addAll(activeCube.getNeighbours());
        }
        potentialActives.removeAll(activeCubes);
    }

    private void determineActivations() {
        for (Cube inactiveCube : potentialActives) {
            inactiveCube.findNeighbours();
            long activeNeighbourCount = getActiveNeighbourCount(inactiveCube);

            if (activeNeighbourCount == 3) {
                toBeActivated.add(inactiveCube);
            }
        }
    }

    private void determineDeactivations() {
        for (Cube activeCube : activeCubes) {
            activeCube.findNeighbours();
            long activeNeighbourCount = getActiveNeighbourCount(activeCube);

            if (activeNeighbourCount != 2 && activeNeighbourCount != 3) {
                toBeDeactivated.add(activeCube);
            }
        }
    }

    private void processChanges() {
        activeCubes.addAll(toBeActivated);
        activeCubes.removeAll(toBeDeactivated);
    }

    private void clearState() {
        potentialActives.clear();
        toBeActivated.clear();
        toBeDeactivated.clear();
    }

    private long getActiveNeighbourCount(Cube conwayCube) {
        return conwayCube
                .getNeighbours()
                .stream()
                .filter(activeCubes::contains)
                .count();
    }
}
