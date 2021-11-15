package me.hyeonic.javabasic.finalkeword;

public class Animal {
//public final class Animal {

    private String name;

    final void eat() {
        System.out.println("먹는 중..");
    }

    public void setName(final String name) {

//        name = "unknown";
    }
}