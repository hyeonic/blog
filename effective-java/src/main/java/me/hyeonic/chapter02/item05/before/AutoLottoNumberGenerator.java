package me.hyeonic.chapter02.item05.before;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator {

    private static final List<Integer> LOTTO_TOTAL_NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());

    private AutoLottoNumberGenerator() {
    }

    public static List<Integer> generate(int size) {
        List<Integer> lottoTotalNumbers = new ArrayList<>(LOTTO_TOTAL_NUMBERS);
        Collections.shuffle(lottoTotalNumbers);

        return lottoTotalNumbers.stream()
                .limit(size)
                .collect(toList());
    }
}
