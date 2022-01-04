package me.hyeonic.modernjavainaction.chapter09.strategy;

public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
