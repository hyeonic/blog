package me.hyeonic.chapter07.item42;

public class LambdaReference {

    public static void main(String[] args) {
        LambdaReference lambdaReference = new LambdaReference();
        lambdaReference.run();
    }

    public void run() {
        Runnable runnable = () -> System.out.println(this);
        runnable.run();
    }

    @Override
    public String toString() {
        return "LambdaReference";
    }
}
