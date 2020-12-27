package com.maartenmusic.day12;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day12 {

    public static void main(String[] args) {
        System.out.println(getResultPart1());
    }

    private static int getResultPart1() {
        File txtFile = new File(FilePathGenerator.getFilePath("day12"));
        List<Action> actions = TxtFileReaders.toActions(txtFile);

        Ship unsinkableII = new Ship();
        unsinkableII.followActions(actions);
        return unsinkableII.getCoordinates().manhattanDistance();
    }
}
