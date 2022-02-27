package me.hyeonic.chapter02.item05.after;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Integer> generate(int size);
}
