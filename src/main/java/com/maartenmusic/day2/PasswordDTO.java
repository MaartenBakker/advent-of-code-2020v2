package com.maartenmusic.day2;

public class PasswordDTO {
    private final int firstNumber;
    private final int secondNumber;
    private final char letter;
    private final String password;

    public PasswordDTO(int firstNumber, int secondNumber, char letter, String password) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.letter = letter;
        this.password = password;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }
}
