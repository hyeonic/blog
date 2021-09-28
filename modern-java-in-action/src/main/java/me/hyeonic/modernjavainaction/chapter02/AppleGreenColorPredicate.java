package me.hyeonic.modernjavainaction.chapter02;

public class AppleGreenColorPredicate implements ApplePredicate {

    // 녹색 사과만 선택
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}