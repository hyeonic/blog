package me.hyeonic.modernjavainaction.chapter02;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    // 무거운 사과만 선택
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
