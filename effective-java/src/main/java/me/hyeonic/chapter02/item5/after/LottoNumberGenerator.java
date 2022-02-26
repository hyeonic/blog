package me.hyeonic.chapter02.item5.after;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Integer> generate();
}
