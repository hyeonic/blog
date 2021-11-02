package me.hyeonic.designpattern.behaviorpattern.strategypattern;

public class Developer {

    void runContext(Strategy strategy) {
        System.out.println("작업 시작");
        strategy.runStrategy();
        System.out.println("작업 종료");
    }
}