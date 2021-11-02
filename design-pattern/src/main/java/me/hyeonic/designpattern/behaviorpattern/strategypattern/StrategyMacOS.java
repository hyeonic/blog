package me.hyeonic.designpattern.behaviorpattern.strategypattern;

public class StrategyMacOS implements Strategy {

    @Override
    public void runStrategy() {
        System.out.println("MacOS를 사용중입니다.");
    }
}