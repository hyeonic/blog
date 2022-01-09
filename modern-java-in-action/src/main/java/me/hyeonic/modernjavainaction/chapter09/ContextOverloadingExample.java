package me.hyeonic.modernjavainaction.chapter09;

public class ContextOverloadingExample {

    public static void main(String[] args) {
        doSomething((Task)() -> System.out.println("Danger!!"));
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }
}
