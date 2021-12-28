package me.hyeonic.modernjavainaction.chapter08;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MapProcess {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, String> favouriteMovies = new HashMap<>(Map.ofEntries(
            Map.entry("Raphael", "Star Wars"),
            Map.entry("Cristina", "Matrix"),
            Map.entry("Olivia", "James Bond")
        ));

        favouriteMovies.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .forEachOrdered(System.out::println);

        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", null));

        Map<String, List<String>> friendsToMovies = new HashMap<>();
        friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>()).add("Star Wars");

        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(1, null);
        counter.put(2, 0);

        counter.computeIfPresent(1, (k, v) -> v + 1);
        counter.computeIfPresent(1, (k, v) -> v + 1);
        counter.computeIfPresent(2, (k, v) -> v + 1);
        counter.computeIfPresent(2, (k, v) -> v + 1);
        System.out.println(counter);


        String key = "Raphael";
        String value = "Jack Reacher 2";
        if (favouriteMovies.containsKey(key) && Objects.equals(favouriteMovies.get(key), value)) {
            favouriteMovies.remove(key);
        }

        favouriteMovies.remove(key, value);

        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        favouriteMovies.replace("Raphael", "Star Wars".toUpperCase());
        favouriteMovies.replace("Raphael", "Star Wars", "Star Wars".toUpperCase());

        Map<String, String> family = Map.ofEntries(
            Map.entry("Teo", "Star Wars"),
            Map.entry("Cristina", "James Bond")
        );

        Map<String, String> friends = Map.ofEntries(
            Map.entry("Raphael", "Star Wars"),
            Map.entry("Cristina", "Matrix")
        );

        // Map<String, String> everyone = new HashMap<>(family);
        // everyone.putAll(friends);
        // System.out.println(everyone);

        Map<String, String> everyone = new HashMap<>(family);
        everyone.forEach((k, v) ->
            everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2)
        );

        Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "JamesBond";

        Long count = moviesToCount.get(movieName);
        if (count == null) {
            moviesToCount.put(movieName, 1L);
        } else {
            moviesToCount.put(movieName, count + 1);
        }

        moviesToCount.merge(movieName, 1L, (k, v) -> v + 1L);
        System.out.println(moviesToCount);

        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallelismThreshold = 1;
        Optional<Long> maxValue = Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));
    }
}
