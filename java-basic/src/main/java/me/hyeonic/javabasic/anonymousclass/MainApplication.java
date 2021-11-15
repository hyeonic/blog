package me.hyeonic.javabasic.anonymousclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

//        Person person = new Person() {
//
//            @Override
//            public String getName() {
//                return super.getName();
//            }
//
//            @Override
//            public void setName(String name) {
//                super.setName(name);
//            }
//
//            @Override
//            public int getAge() {
//                return super.getAge();
//            }
//
//            @Override
//            public void setAge(int age) {
//                super.setAge(age);
//            }
//        };

//        List<Integer> numbers1 = new ArrayList<>(List.of(3, 2, 1, 4, 10, 5, 7));
//        numbers1.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        System.out.println(numbers1);

//        List<Integer> numbers2 = new ArrayList<>(List.of(3, 2, 1, 4, 10, 5, 7));
//        numbers2.sort((o1, o2) -> o1 - o2);
//
//        System.out.println(numbers2);

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> comparator2 = ((o1, o2) -> o1 - o2);
    }
}