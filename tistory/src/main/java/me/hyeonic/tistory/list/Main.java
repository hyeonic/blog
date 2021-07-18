package me.hyeonic.tistory.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
//        List<Integer> list = Arrays.asList(array);
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));

        System.out.println(list);

        array[0] = 4;
        array[1] = 5;

        System.out.println(list);
    }
}