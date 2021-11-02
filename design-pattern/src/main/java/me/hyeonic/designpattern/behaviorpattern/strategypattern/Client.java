package me.hyeonic.designpattern.behaviorpattern.strategypattern;

public class Client {

    public static void main(String[] args) {
        Strategy strategy = null;
        Developer developer = new Developer();

        // 개발자에게 Linux로 개발을 진행하게 한다.
        strategy = new StrategyLinux();
        developer.runContext(strategy);

        System.out.println();

        // 개발자에게 Mac OS로 개발을 진행하게 한다.
        strategy = new StrategyMacOS();
        developer.runContext(strategy);

        System.out.println();

        // 개발자에게 Windows로 개발을 진행하게 한다.
        strategy = new StrategyWindows();
        developer.runContext(strategy);
    }
}