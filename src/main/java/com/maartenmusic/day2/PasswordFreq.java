package com.maartenmusic.day2;

public class PasswordFreq extends Password {
    private final int rangeMin;
    private final int rangeMax;


    public PasswordFreq(int rangeMin, int rangeMax, char letter, String password) {
        super (letter, password);
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }

    public boolean checkRange() {
        long frequency = getLetterFrequency();
        return (frequency >= rangeMin && frequency <= rangeMax);
    }

    private Long getLetterFrequency() {
        return this.password.chars()
                .filter(ch-> ch == this.letter)
                .count();
    }
}
