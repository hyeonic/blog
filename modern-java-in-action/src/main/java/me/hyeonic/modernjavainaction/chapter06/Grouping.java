package me.hyeonic.modernjavainaction.chapter06;

import static java.util.stream.Collectors.*;
import static me.hyeonic.modernjavainaction.chapter06.Dish.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Grouping {
    public static void main(String[] args) {
        Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
            groupingBy(dish -> {
                if (dish.getCalories() <= 400)
                    return CaloricLevel.DIET;
                else if (dish.getCalories() <= 700)
                    return CaloricLevel.NORMAL;
                else
                    return CaloricLevel.FAT;
            })
        );

        Map<Type, List<Dish>> caloricDishesByType0 = menu.stream()
            .filter(dish -> dish.getCalories() > 500)
            .collect(groupingBy(Dish::getType));

        System.out.println(caloricDishesByType0);

        Map<Type, List<Dish>> caloricDishesByType1 = menu.stream()
            .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));

        System.out.println(caloricDishesByType1);

        Map<Type, List<String>> dishNamesByType2 = menu.stream()
            .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(dishNamesByType2);

        Map<Type, Set<String>> dishNamesByType3 = menu.stream()
            .collect(groupingBy(Dish::getType,
                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));

        System.out.println(dishNamesByType3);

        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
            groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }))
        );

        System.out.println(dishesByTypeCaloricLevel);

        Map<Type, Long> typesCount = menu.stream()
            .collect(groupingBy(Dish::getType, counting()));

        Map<Type, Optional<Dish>> mostCaloricByType = menu.stream()
            .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        Map<Type, Dish> mostCaloricByType1 = menu.stream()
            .collect(groupingBy(Dish::getType, collectingAndThen(
                maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        Map<Type, Integer> totalCaloriesByType0 = menu.stream().collect(
            groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        Map<Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
            groupingBy(Dish::getType, mapping(dish -> {
                if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT;
                }, toSet()
            )));

        Map<Type, Set<CaloricLevel>> caloricLevelsByType1 = menu.stream().collect(
            groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toCollection(HashSet::new)
            )));
    }
}