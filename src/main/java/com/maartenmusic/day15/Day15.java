package com.maartenmusic.day15;

import java.util.*;
import java.util.List;

public class Day15 {

    public static void main(String[] args) {
        System.out.println(getResultOfPart1());
        System.out.println(getResultOfPart2());
    }

    static int getResultOfPart1() {
        List<Integer> startingNumbers = Arrays.asList(0,5,4,1,10,14,7);
        Game game = new Game(startingNumbers);
        return game.playGame(2020);
    }

    static int getResultOfPart2() {
        List<Integer> startingNumbers = Arrays.asList(0,5,4,1,10,14,7);
        Game game = new Game(startingNumbers);
        return game.playGame(30000000);
    }
}
