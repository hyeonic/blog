package me.hyeonic.chapter07.item42;

import java.util.Comparator;

public class LambdaExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
    }
}
