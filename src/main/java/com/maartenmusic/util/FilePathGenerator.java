package com.maartenmusic.util;

public class FilePathGenerator {

    public static String generate(String day) {
        return "src/main/java/com/maartenmusic/" + day + "/input.txt";
    }
}
