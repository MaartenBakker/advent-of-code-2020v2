package com.maartenmusic.day2;

public class PasswordPos extends Password {
    private final int position1;
    private final int position2;


    public PasswordPos(int position1, int position2, char letter, String password) {
        super (letter, password);
        this.position1 = position1;
        this.position2 = position2;
    }

    public boolean checkPositions() {

        return (password.charAt(position1 - 1) == letter && password.charAt(position2 - 1) != letter ||
                password.charAt(position1 - 1) != letter && password.charAt(position2 - 1) == letter);
    }
}
