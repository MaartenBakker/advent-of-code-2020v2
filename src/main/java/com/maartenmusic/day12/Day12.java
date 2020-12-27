package com.maartenmusic.day12;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day12 {

    public static void main(String[] args) {
        System.out.println(getResultPart1());
        System.out.println(getResultPart2());
    }

    private static int getResultPart1() {
        File txtFile = new File(FilePathGenerator.getFilePath("day12"));
        List<ShipAction> shipActions = TxtFileReaders.toShipActions(txtFile);

        Ship unsinkableII = new Ship();
        unsinkableII.followActions(shipActions);
        return unsinkableII.getCoordinates().manhattanDistance();
    }

    private static int getResultPart2() {
        File txtFile = new File(FilePathGenerator.getFilePath("day12"));
        List<ShipAction> shipActions = TxtFileReaders.toShipActions(txtFile);

        Ship unsinkableIII = new WayPointShip();
        unsinkableIII.followActions(shipActions);
        return unsinkableIII.getCoordinates().manhattanDistance();

    }
}
