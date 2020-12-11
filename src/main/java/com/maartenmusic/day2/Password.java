package com.maartenmusic.day2;

public abstract class Password {
    final char letter;
    final String password;

    public Password(char letter, String password) {
        this.letter = letter;
        this.password = password;
    }
}
