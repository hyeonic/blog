package me.hyeonic.modernjavainaction.chapter02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chapter02Application {

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e : list) {
            if(p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
//        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
//        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);

        List<Apple> greenApples = filterApples(inventory, Color.GREEN, 0, true);
        List<Apple> heavyApples = filterApples(inventory, null, 150, false);

        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedHeavyPredicate());

        prettyPrintApple(inventory, new AppleSimpleFormatter());

//        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
//
//            @Override
//            public boolean test(Apple apple) {
//                return Color.RED.equals(apple.getColor());
//            }
//        });

        List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        inventory.sort((o1, o2) -> o1.getWeight() - o2.getWeight());
    }
}