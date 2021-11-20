package me.hyeonic.javabasic.instance_of;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Animal whale = new Whale();
        Animal penguin = new Penguin();

        System.out.println(animal instanceof Animal);

        System.out.println(whale instanceof Animal);
        System.out.println(whale instanceof Whale);

        System.out.println(penguin instanceof Animal);
        System.out.println(penguin instanceof Penguin);

        System.out.println(animal instanceof Object);
        System.out.println(whale instanceof Object);
        System.out.println(penguin instanceof Object);

        System.out.println(whale instanceof Swimmable);
        System.out.println(penguin instanceof Swimmable);
    }
}