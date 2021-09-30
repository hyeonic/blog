package me.hyeonic.modernjavainaction.chapter03;

import me.hyeonic.modernjavainaction.chapter02.Apple;

@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple);
}