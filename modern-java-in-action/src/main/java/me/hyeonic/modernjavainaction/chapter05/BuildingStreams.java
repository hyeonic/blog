package me.hyeonic.modernjavainaction.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String... args) throws Exception {
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> homeValueStream1 = Stream.ofNullable(System.getProperty("home"));

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 4)
                .filter(n -> n < 100)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        // iterate를 이용한 피보나치
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.printf("(%d, %d)", t[0], t[1]));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // Stream.generate를 이용한 임의의 double 스트림
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // Stream.generate을 이용한 요소 1을 갖는 스트림
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return previous;
            }

        };
        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);

//        long uniqueWords = Files.lines(Paths.get("lambdasinaction/chap5/data.txt"), Charset.defaultCharset())
//                .flatMap(line -> Arrays.stream(line.split(" ")))
//                .distinct()
//                .count();

//        System.out.println("There are " + uniqueWords + " unique words in data.txt");

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

        } catch (IOException e) {
            // 파일을 열다가 예외가 발생하면 처리한다.
        }
    }
}