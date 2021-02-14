package com.maartenmusic.day17;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PocketDimension {
    @Getter
    private final List<ConwayCube> activeCubes = new ArrayList<>();
    private final Set<ConwayCube> potentialActives = new HashSet<>();
    private final List<ConwayCube> toBeDeactivated = new ArrayList<>();
    private final List<ConwayCube> toBeActivated = new ArrayList<>();

    public void addActiveCubes(List<ConwayCube> conwayCubes) {
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
        for (ConwayCube activeCube : activeCubes) {
            activeCube.findNeighbours();
            potentialActives.addAll(activeCube.getNeighbours());
        }
        potentialActives.removeAll(activeCubes);
    }

    private void determineActivations() {
        for (ConwayCube inactiveCube : potentialActives) {
            inactiveCube.findNeighbours();
            long activeNeighbourCount = getActiveNeighbourCount(inactiveCube);

            if (activeNeighbourCount == 3) {
                toBeActivated.add(inactiveCube);
            }
        }
    }

    private void determineDeactivations() {
        for (ConwayCube activeCube : activeCubes) {
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

    private long getActiveNeighbourCount(ConwayCube conwayCube) {
        return conwayCube
                .getNeighbours()
                .stream()
                .filter(activeCubes::contains)
                .count();
    }
}
