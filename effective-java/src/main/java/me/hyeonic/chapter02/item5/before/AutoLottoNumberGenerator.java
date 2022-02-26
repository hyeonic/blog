package me.hyeonic.chapter02.item5.before;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator {

    private static final List<Integer> LOTTO_TOTAL_NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());

    private static final int LOTTO_NUMBERS_FROM_INDEX = 0;
    private static final int LOTTO_NUMBERS_TO_INDEX = 6;

    private AutoLottoNumberGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> lottoTotalNumbers = new ArrayList<>(LOTTO_TOTAL_NUMBERS);
        Collections.shuffle(lottoTotalNumbers);

        return lottoTotalNumbers.subList(LOTTO_NUMBERS_FROM_INDEX, LOTTO_NUMBERS_TO_INDEX);
    }
}
