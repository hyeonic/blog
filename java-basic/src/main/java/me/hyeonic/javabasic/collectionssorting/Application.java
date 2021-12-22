package me.hyeonic.javabasic.collectionssorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("java", "c", "c++", "c#", "python", "ruby", "kotlin"));
        Collections.sort(words);
        words.forEach(System.out::println);

        words.sort(Comparator.naturalOrder());
        words.forEach(System.out::println);
    }
}
