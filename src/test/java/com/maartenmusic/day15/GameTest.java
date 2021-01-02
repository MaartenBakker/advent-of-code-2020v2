package com.maartenmusic.day15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Game() {
        List<Integer> startingNumbers = Arrays.asList(1,3,2,3);

        Game game = new Game(startingNumbers);

        assertEquals(3, game.getLastNumber());
        assertEquals(4, game.getSizeOfStartingNumbers());
        assertEquals(0, game.getGameNumbers().get(1).get(0));
        assertEquals(1, game.getGameNumbers().get(3).get(0));
        assertEquals(2, game.getGameNumbers().get(2).get(0));
        assertEquals(3, game.getGameNumbers().get(3).get(1));
    }

    @Test
    void playGame() {
        List<Integer> startingNumbers = Arrays.asList(0,3,6);
        Game game = new Game(startingNumbers);

        assertEquals(436, game.playGame(2020));

        game = new Game(startingNumbers);

        assertEquals(175594, game.playGame(30000000));

        startingNumbers = Arrays.asList(1,3,2);
        game = new Game(startingNumbers);

        assertEquals(1, game.playGame(2020));

        startingNumbers = Arrays.asList(2,1,3);
        game = new Game(startingNumbers);

        assertEquals(10, game.playGame(2020));
    }

    @Test
    void playGameTooFewRoundsException() {
        List<Integer> startingNumbers = Arrays.asList(0,3,6);
        Game game = new Game(startingNumbers);

        assertThrows(TooFewRoundsException.class, () -> game.playGame(1));
    }

    @Test
    void sayNumber() {
        List<Integer> startingNumbers = Arrays.asList(1,3,2,3);
        Game game = new Game(startingNumbers);
        assertEquals(2, game.sayNumber());

        startingNumbers = Arrays.asList(1,3,2,4);
        game = new Game(startingNumbers);

        assertEquals(0, game.sayNumber());
    }
}