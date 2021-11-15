package me.hyeonic.javabasic.anonymousclass;

import java.util.Comparator;

public class LambdaExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator2 = (o1, o2) -> o1 - o2;
    }
}