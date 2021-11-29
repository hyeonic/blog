package me.hyeonic.modernjavainaction.chapter06;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static me.hyeonic.modernjavainaction.chapter06.Dish.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class Partitioning {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionedMenu);

        Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    public boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt(candidate);
        return IntStream.range(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(partitioningBy(candidate -> isPrime(candidate)));
    }
}