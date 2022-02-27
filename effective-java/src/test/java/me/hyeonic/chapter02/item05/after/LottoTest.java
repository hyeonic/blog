package me.hyeonic.chapter02.item05.after;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("자동으로 로또 번호를 발급 받는다.")
    @Test
    void 자동_로또_번호_발급() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        // when
        Lotto lotto = new Lotto(lottoNumberGenerator);

        // then
        assertThat(lotto.getLottoNumbers())
                .isNotIn(new LottoNumber(0), new LottoNumber(46)); // 적절 한가?
    }

    @DisplayName("수동으로 로또 번호를 생성한다.")
    @Test
    void 수동_로또_번호_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumberGenerator lottoNumberGenerator = (size) -> numbers;

        // when
        Lotto lotto = new Lotto(lottoNumberGenerator);

        // then
        assertThat(lotto.getLottoNumbers())
                .contains(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6));
    }
}