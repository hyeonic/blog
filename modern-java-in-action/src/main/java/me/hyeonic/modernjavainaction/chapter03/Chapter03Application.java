package me.hyeonic.modernjavainaction.chapter03;

import me.hyeonic.modernjavainaction.chapter02.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Chapter03Application {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br); // BufferedReader 객체 처리
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Comparator<Apple> byWeight1 = new Comparator<>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Comparator<Apple> byWeight2 = (o1, o2) -> o1.getWeight() - o2.getWeight();

        String oneLine = processFile(br -> br.readLine());
        String twoLine = processFile(br -> br.readLine() + br.readLine());

        List<String> listOfStrings = new ArrayList<>();
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        forEach(
                Arrays.asList(1, 2, 3, 4, 5),
                i -> System.out.println(i) // Consumer의 accept 메서드를 구현하는 람다
        );

        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                s -> s.length() // function의 apply 메서드를 구현하는 람다
        );

        IntPredicate evenNumbers = i -> i % 2 == 0;
        evenNumbers.test(1000); // true, 박싱 과정이 진행되지 않는다.

        Predicate<Integer> oddNumbers = i -> i % 2 != 0;
        oddNumbers.test(1000); // false 박싱 과정이 진행된다.

        Function<BufferedReader, String> f = br -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        List<Apple> inventory = new ArrayList<>();
        List<Apple> greenApples = filter(inventory, apple -> Color.GREEN.equals(apple.getColor()));

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        inventory.sort(Comparator.comparingInt(Apple::getWeight));

        inventory.sort(Comparator.comparingInt(Apple::getWeight).reversed());

        inventory.sort(Comparator.comparingInt(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
    }
}