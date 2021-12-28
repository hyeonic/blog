package me.hyeonic.modernjavainaction.chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethod {

    public static void main(String[] args) {
        List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);

        // friends.add("Chih-Chun"); UnsupportedOperationException

        friends = new ArrayList<>(List.of("Raphael", "Olivia", "Thibaut"));
        friends.add("Chih-Chun");
        System.out.println(friends);

        // friends = List.of(null); NullPointerException
        System.out.println(friends);

        Set<String> noneDuplicatedFriends = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println(noneDuplicatedFriends);

        // noneDuplicatedFriends = Set.of("Raphael", "Olivia", "Olivia"); IllegalArgumentException

        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        System.out.println(ageOfFriends);

        ageOfFriends = Map.ofEntries(
            Map.entry("Raphael", 30),
            Map.entry("Olivia", 25),
            Map.entry("Thibaut", 26)
        );
    }
}
