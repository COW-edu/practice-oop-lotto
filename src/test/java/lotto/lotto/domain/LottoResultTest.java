package lotto.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LottoResultTest {

    @DisplayName("보너스 번호가 당첨 번호에 존재한다면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenBonusNumberInResultNumbers() {
        // given
        int targetSize = Lotto.SIZE_OF_LOTTO_NUMBERS;
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 0; i < targetSize; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(Lotto.SIZE_OF_LOTTO_NUMBERS);

        // when
        var throwable = Assertions.catchThrowable(() -> LottoResult.of(numbers, bonusNumbers));

        // then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호가 로또 사이즈와 다르다면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenResultNumbersNotEqualsLottoSize() {
        // given
        int targetSize = Lotto.SIZE_OF_LOTTO_NUMBERS - 1;
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 0; i < targetSize; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(LottoNumber.MAX_VALUE);

        // when
        var throwable = Assertions.catchThrowable(() -> LottoResult.of(numbers, bonusNumbers));

        // then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 번호가 포함된다면 true를 반환한다.")
    @Test
    void returnTrueWhenResultNumbersContainTargetNumber() {
        // given
        var targetNumber = LottoNumber.valueOf(LottoNumber.MIN_VALUE);
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(targetNumber);
        for (int i = 1; i < Lotto.SIZE_OF_LOTTO_NUMBERS; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        var lottoResult = LottoResult.of(numbers, bonusNumbers);

        // when
        var actual = lottoResult.containWinningNumbers(targetNumber);

        // then
        Assertions.assertThat(actual).isTrue();
    }
    
    @DisplayName("당첨 번호에 번호가 포함되지 않는다면 false를 반환한다.")
    @Test
    void returnFalseWhenResultNumbersNotContainTargetNumber() {
        // given
        var targetNumber = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 0; i < Lotto.SIZE_OF_LOTTO_NUMBERS; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        var lottoResult = LottoResult.of(numbers, bonusNumbers);

        // when
        var actual = lottoResult.containWinningNumbers(targetNumber);

        // then
        Assertions.assertThat(actual).isFalse();
    }

    @DisplayName("보너스 번호에 대상 번호가 포함된다면 true를 반환한다.")
    @Test
    void returnTrueWhenBonusNumberContainTargetNumber() {
        // given
        var targetNumber = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 0; i < Lotto.SIZE_OF_LOTTO_NUMBERS; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        var lottoResult = LottoResult.of(numbers, bonusNumbers);

        // when
        var actual = lottoResult.containBonusNumbers(targetNumber);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("보너스 번호에 대상 번호가 포함되지 않는다면 false를 반환한다.")
    @Test
    void returnFalseWhenBonusNumberNotContainTargetNumber() {
        // given
        var targetNumber = LottoNumber.valueOf(LottoNumber.MIN_VALUE);
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 0; i < Lotto.SIZE_OF_LOTTO_NUMBERS; i++) {
            int targetValue = LottoNumber.MIN_VALUE + i;
            numbers.add(LottoNumber.valueOf(targetValue));
        }
        var bonusNumbers = LottoNumber.valueOf(LottoNumber.MAX_VALUE);
        var lottoResult = LottoResult.of(numbers, bonusNumbers);

        // when
        var actual = lottoResult.containBonusNumbers(targetNumber);

        // then
        Assertions.assertThat(actual).isFalse();
    }


}
