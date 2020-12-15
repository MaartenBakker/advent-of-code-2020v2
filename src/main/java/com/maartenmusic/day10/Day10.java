package com.maartenmusic.day10;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Day10 {

    public static void main(String[] args) {

        File txtFile = new File(FilePathGenerator.getFilePath("day10"));
        List<Integer> data = FileReaders.readTxtFileIntoArrayListOfInteger(txtFile);

        data.add(0);
        data.add(Collections.max(data) + 3);
        Collections.sort(data);

        int diffOfOne = 0;
        int diffOfThree = 0;

        for (int i = 1; i < data.size(); i++) {
            int diff = data.get(i) - data.get(i - 1);
            if (diff == 1) {
                diffOfOne++;
            } else if (diff == 3) {
                diffOfThree++;
            }
        }

        System.out.println(diffOfOne * diffOfThree);
    }
}
