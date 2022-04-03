package me.hyeonic.chapter10.item70;

public class UncheckedExceptionExample {

    public static void main(String[] args) {
        some();
    }

    private static void some() {
        throw new IllegalArgumentException();
    }
}
