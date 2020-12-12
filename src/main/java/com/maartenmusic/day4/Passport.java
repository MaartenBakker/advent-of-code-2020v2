package com.maartenmusic.day4;

import java.util.HashMap;
import java.util.Map;

public class Passport {
    private final String rawData;
    private final Map<String, String> mappedData = new HashMap<>();

    public Passport(String rawData) {
        this.rawData = rawData;
        generateMappedData();
    }

    public String getRawData() {
        return rawData;
    }

    public void generateMappedData() {
        String[] splitData = this.rawData.split(" ");
        for (String str : splitData ) {
            String[] splitStr = str.split(":");
            this.mappedData.put(splitStr[0], splitStr[1]);
        }
    }

    public Map<String, String> getMappedData() {
        return mappedData;
    }

}
