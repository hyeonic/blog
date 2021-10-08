package me.hyeonic.modernjavainaction.chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter04Application {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("fries", true, 500, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("fruit", true, 120, Type.OTHER),
                new Dish("pizza", false, 600, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish : menu) {
            if(dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

//        List<String> lowCaloricDishesName = new ArrayList<>();
//        for (Dish dish : lowCaloricDishes) {
//            lowCaloricDishedName.add(dish.getName());
//        }

        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400) // 400 칼로리 이하의 요리 선택
                .sorted(Comparator.comparing(Dish::getCalories)) // 칼로리로 요리 정렬
                .map(Dish::getName) // 요리명 추출
                .collect(Collectors.toList()); // 모든 요리명을 리스트에 저장

        List<String> threeHighCaloricDishNames = menu.stream() // 메뉴에서 스트림을 얻는다.
                .filter(dish -> dish.getCalories() > 300) // 파이프라인 연산 만들기. 고칼로리 요리 필터링
                .map(Dish::getName) // 요리명 추출
                .limit(3) // 선착순 세 개 선택
                .collect(Collectors.toList()); // 결과를 다른 리스트로 저장
        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        stream.forEach(System.out::println);

//        List<String> names = new ArrayList<>();
//        for (Dish dish : menu) { // 메뉴 리스트를 명시적으로 순차 반복한다.
//            names.add(dish.getName());
//        }
//
//        Iterator<Dish> iterator = menu.iterator();
//        while (iterator.hasNext()) {
//            Dish dish = iterator.next();
//            names.add(dish.getName());
//        }

        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}