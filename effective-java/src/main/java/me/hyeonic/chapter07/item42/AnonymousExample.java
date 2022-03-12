package me.hyeonic.chapter07.item42;

import java.util.Comparator;

public class AnonymousExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }
}
