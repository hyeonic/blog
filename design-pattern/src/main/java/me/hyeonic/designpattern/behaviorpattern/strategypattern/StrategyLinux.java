package me.hyeonic.designpattern.behaviorpattern.strategypattern;

public class StrategyLinux implements Strategy {

    @Override
    public void runStrategy() {
        System.out.println("Linux를 사용중입니다.");
    }
}