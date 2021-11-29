package me.hyeonic.modernjavainaction.chapter06;

import static me.hyeonic.modernjavainaction.chapter06.Dish.*;

import java.util.ArrayList;
import java.util.List;

public class Collector {

    public static void main(String[] args) {
        List<Dish> dishes0 = menu.stream().collect(new ToListCollector<>());
        System.out.println(dishes0);

        List<Dish> dishes1 = menu.stream().collect(
            ArrayList::new,
            List::add,
            List::addAll
        );
        System.out.println(dishes1);
    }
}