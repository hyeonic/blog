package me.hyeonic.javabasic.functionalinterface;

@FunctionalInterface
public interface Adder {

    int add(int a, int b);

    default void print(int a, int b) {
        System.out.print(add(a, b));
    }
}