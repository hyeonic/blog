package me.hyeonic.javabasic.anonymousclass;

import java.util.Comparator;

public class AnonymousExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
    }
}