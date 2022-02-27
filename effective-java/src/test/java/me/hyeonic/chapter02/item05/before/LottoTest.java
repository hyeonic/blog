package me.hyeonic.chapter02.item05.before;

import static org.assertj.core.api.Assertions.assertThat;

import me.hyeonic.chapter02.item05.after.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("자동으로 로또 번호를 발급 받는다.")
    @Test
    void 자동_로또_번호_발급() {
        // given & when & then
        assertThat(new Lotto().getLottoNumbers())
                .isNotIn(new LottoNumber(0), new LottoNumber(46)); // 적절 한가?
    }
}