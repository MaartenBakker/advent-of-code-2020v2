package com.maartenmusic.day13;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day13"));
        System.out.println(getResultOfPart1(txtFile));

    }

    static int getResultOfPart1(File txtFile) {
        int timeStamp = TxtFileReaders.toTimeStamp(txtFile);
        List<Integer> busIDs = TxtFileReaders.toBusIDs(txtFile);

        int[] resultIdAndStamp = checkIDs(busIDs, timeStamp);

        return resultIdAndStamp[0] * (resultIdAndStamp[1] - timeStamp);
    }

    static int[] checkIDs(List<Integer> busIDs, int timeStamp) {
        for (int ID : busIDs) {
            if(timeStamp % ID == 0) {
                return new int[]{ID, timeStamp};
            }
        }
        return checkIDs(busIDs, ++timeStamp);
    }
}
