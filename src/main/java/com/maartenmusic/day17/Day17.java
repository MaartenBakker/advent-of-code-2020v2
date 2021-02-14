package com.maartenmusic.day17;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day17 {

    public static void main(String[] args) {
        //part 1
        File txtFile = new File(FilePathGenerator.generate("day17"));
        List<Cube> startingCubes = TxtFileReaders.toConwayCubes(txtFile);
        PocketDimension pocketDimension = new PocketDimension();
        pocketDimension.addActiveCubes(startingCubes);

        for (int i = 0; i < 6; i++) {
            pocketDimension.changeState();
        }

        System.out.println(pocketDimension.getActiveCubes().size());

        //part 2
        startingCubes = TxtFileReaders.toConwayHyperCubes(txtFile);
        pocketDimension = new PocketDimension();
        pocketDimension.addActiveCubes(startingCubes);

        for (int i = 0; i < 6; i++) {
            pocketDimension.changeState();
        }

        System.out.println(pocketDimension.getActiveCubes().size());

    }
}
