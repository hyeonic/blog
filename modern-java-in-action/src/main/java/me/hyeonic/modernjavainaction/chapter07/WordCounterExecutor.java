package me.hyeonic.modernjavainaction.chapter07;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterExecutor {
    private static final String SENTENCE =
        "Nel    mezzo del cammin di nostra vita " +
            "mi ritrovai in una selva oscura " +
            "ch     la dritta via era smarrita ";

    public static void main(String[] args) {
        // Stream<Character> stream = IntStream.range(0, SENTENCE.length())
        //                                     .mapToObj(SENTENCE::charAt);
        //
        // System.out.println("Found " + countWords(stream) + " words");

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println("Found " + countWords(stream) + " words");
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                                                    WordCounter::accumulate,
                                                    WordCounter::combine);

        return wordCounter.getCounter();
    }
}
