package me.hyeonic.chapter02.item5.after;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = lottoNumberGenerator.generate();
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toSet());
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
