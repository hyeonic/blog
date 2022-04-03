package me.hyeonic.chapter10.item70;

import java.io.IOException;

public class CheckedExceptionExample {

    public static void main(String[] args) {
        try {
            some();
        } catch (IOException e) {
            // TODO
        }
    }

    public static void some() throws IOException {
        throw new IOException();
    }
}
