package com.maartenmusic.day13;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Day13 {
    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.getFilePath("day13"));
        System.out.println(getResultOfPart1(txtFile));
        System.out.println(getResultOfPart2(txtFile));

    }

    static BigInteger getResultOfPart2(File txtFile) {
        Map<Integer, Integer> busIdsAndIndex = TxtFileReaders.toBusIdsAndIndex(txtFile);
        List<Integer> busIds = TxtFileReaders.toBusIDs(txtFile);
//        int startCount = 100000000000000;
        BigInteger startCount = new BigInteger(String.valueOf(Collections.max(busIds)));
        System.out.println(startCount);
        BigInteger counter = new BigInteger(startCount.toString());

        while(true) {
            if (checkIDsAndIndex(busIds, busIdsAndIndex, counter.subtract(BigInteger.valueOf(busIdsAndIndex.get(startCount.intValue()))))) {
                return counter.subtract(BigInteger.valueOf(busIdsAndIndex.get(startCount.intValue())));
            }
            counter = counter.add(startCount);
        }
    }

//    check if counter % firstId == 0;
//    if true
//    check if counter + indexOfNext % nextId == 0;
//    if true
//    etc.
//    if make it to all id's
//    return true

    static boolean checkIDsAndIndex(List<Integer> busIds, Map<Integer, Integer> busIdsAndIndex, BigInteger counter) {
        for (int id : busIds) {
            BigInteger currentCounter = counter.add(BigInteger.valueOf(busIdsAndIndex.get(id)));
            if (!checkId(id, currentCounter)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkId(int id, BigInteger counter) {
        return counter.mod(BigInteger.valueOf(id)).equals(new BigInteger("0"));
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
