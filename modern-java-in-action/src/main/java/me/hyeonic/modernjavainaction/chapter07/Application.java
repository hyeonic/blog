package me.hyeonic.modernjavainaction.chapter07;

import java.util.stream.LongStream;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.sideEffectSum(10);
    }

    public long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
}
