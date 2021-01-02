package com.maartenmusic.day15;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Game {
    private Map<Integer, List<Integer>> gameNumbers;
    private int lastNumber;
    private final int sizeOfStartingNumbers;

    public Game(List<Integer> startingNumbers) {
        setGameNumbers(startingNumbers);
        setLastNumber(startingNumbers);
        this.sizeOfStartingNumbers = startingNumbers.size();
    }

    public int playGame(int rounds) {
        if (rounds < sizeOfStartingNumbers) {
            throw new TooFewRoundsException("Number of rounds must exceed length of starting numbers\t" +
                    "Number of starting numbers: " + sizeOfStartingNumbers);
        }

        for (int i = sizeOfStartingNumbers; i < rounds ; i++) {
            int nextNumber = sayNumber();

            if (gameNumbers.containsKey(nextNumber)){
                gameNumbers.get(nextNumber).add(i);
            } else {
                List<Integer> newIndexes = new ArrayList<>();
                newIndexes.add(i);
                gameNumbers.put(nextNumber, newIndexes);
            }

            lastNumber = nextNumber;
        }
        return lastNumber;
    }

    int sayNumber() {
        List<Integer> indexesOfLastNumber = gameNumbers.get(lastNumber);

        if (indexesOfLastNumber.size() == 1) { // last number is the only occurrence
            return 0;
        } else {
            int lastIndex = indexesOfLastNumber.get(indexesOfLastNumber.size() - 1);
            int secondToLastIndex = indexesOfLastNumber.get(indexesOfLastNumber.size() - 2);

            return lastIndex - secondToLastIndex;
        }
    }

    void setGameNumbers(List<Integer> startingNumbers) {
        Map<Integer, List<Integer>> gameNumbers = new HashMap<>();

        for (int i = 0; i < startingNumbers.size(); i++) {

            int key = startingNumbers.get(i);

//            if not first occurrence of number, add it to indexes
            if(gameNumbers.containsKey(key)) {
                gameNumbers.get(key).add(i);

            } else {
//             else add current number and index to map
                List<Integer> list = new ArrayList<>();
                list.add(i);
                gameNumbers.put(startingNumbers.get(i), list);
            }

        }
        this.gameNumbers = gameNumbers;
    }

    void setLastNumber(List<Integer> startingNumbers) {
        this.lastNumber = startingNumbers.get(startingNumbers.size()-1);
    }
}
