package me.hyeonic.modernjavainaction.chapter06;

import static java.util.stream.Collectors.*;
import static me.hyeonic.modernjavainaction.chapter06.Dish.*;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish0 =
            menu.stream()
                .collect(maxBy(dishCaloriesComparator));

        Integer totalCalories0 = menu.stream()
            .collect(summingInt(Dish::getCalories));

        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu0 = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu0);

        // String shortMenu1 = menu.stream().collect(joining());
        // System.out.println(shortMenu1);

        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu2);

        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> mostCalorieDish1 = menu.stream()
            .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        Integer totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        Integer totalCalories3 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        Integer totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();
    }
}