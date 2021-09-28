package me.hyeonic.modernjavainaction.chapter02;

public class AppleRedHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}