package com.maartenmusic.day13;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.TxtFileReaders;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Day13v2 {

    public static void main(String[] args) {
        File txtFile = new File(FilePathGenerator.generate("day13"));
        System.out.println(resultOfPart2(txtFile));
    }

    static long resultOfPart2(File txtFile) {
        List<Bus> buses = TxtFileReaders.toBuses(txtFile);

        Collections.sort(buses);
        Collections.reverse(buses); //slowest bus first

        Bus slowestBus = buses.get(0);
        Bus secondBus = buses.get(1);

        long timeStamp = slowestBus.getId() - slowestBus.getOffSet();
        long interval = slowestBus.getId();

        while (!slowestBus.matchesRequirement(timeStamp) || !secondBus.matchesRequirement(timeStamp)) {
            timeStamp += interval;
        }

        interval = slowestBus.getId() * secondBus.getId();

        while(true) {
            if(allBusesMatchRequirements(timeStamp, buses)) {
                return timeStamp;
            }
            timeStamp += interval;
        }
    }

    static boolean allBusesMatchRequirements(long timeStamp, List<Bus> buses) {
        return buses.stream().allMatch(bus -> bus.matchesRequirement(timeStamp));
    }
}
