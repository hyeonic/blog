package me.hyeonic.designpattern.behaviorpattern.strategypattern;

public class StrategyWindows implements Strategy {

    @Override
    public void runStrategy() {
        System.out.println("Windows를 사용중입니다.");
    }
}