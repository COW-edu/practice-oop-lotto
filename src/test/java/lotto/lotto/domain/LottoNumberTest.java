package lotto.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또 번호의 범위를 벗어나면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, LottoNumber.MIN_VALUE - 1, LottoNumber.MAX_VALUE +1, Integer.MAX_VALUE })
    void throwExceptionWhenOutRangeValue(int value) {
        // when
        var throwable = Assertions.catchThrowable(() -> LottoNumber.valueOf(value));

        // then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 값이라면 로또 번호가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_VALUE, (LottoNumber.MIN_VALUE + LottoNumber.MAX_VALUE) / 2, LottoNumber.MAX_VALUE})
    void createLottoNumberWhenValidValue(int value) {
        // when
        var actual = LottoNumber.valueOf(value);

        // then
        Assertions.assertThat(actual.getValue()).isEqualTo(value);
    }

    @DisplayName("value가 같다면 객체의 동등 해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_VALUE, (LottoNumber.MIN_VALUE + LottoNumber.MAX_VALUE) / 2, LottoNumber.MAX_VALUE})
    void sameValueEnsureEquals(int value) {
        // given
        var lottoNumber1 = LottoNumber.valueOf(value);
        var lottoNumber2 = LottoNumber.valueOf(value);

        // when
        var actual = lottoNumber1.equals(lottoNumber2);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("value가 다르다면 객체는 동등 하지 않아야 한다")
    @Test
    void notSameValueNotEquals() {
        // given
        var lottoNumber1 = LottoNumber.valueOf(LottoNumber.MIN_VALUE);
        var lottoNumber2 = LottoNumber.valueOf(LottoNumber.MAX_VALUE);

        // when
        var actual = lottoNumber1.equals(lottoNumber2);

        // then
        Assertions.assertThat(actual).isFalse();
    }
}
