package lotto.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMatchingInfoTest {
    @DisplayName("value가 같다면 객체의 동등 해야 한다.")
    @Test
    void sameValueEnsureEquals() {
        // given
        var matchedNumber = 1;
        var matchedBonusNumber = 1;
        var lottoMatchingInfo1 = LottoMatchingInfo.builder().matchedNumbers(matchedNumber).matchedBonusNumbers(matchedBonusNumber).build();
        var lottoMatchingInfo2 = LottoMatchingInfo.builder().matchedNumbers(matchedNumber).matchedBonusNumbers(matchedBonusNumber).build();

        // when
        var actual = lottoMatchingInfo1.equals(lottoMatchingInfo2);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("value가 다르다면 객체는 동등 하지 않아야 한다")
    @ParameterizedTest
    @CsvSource({"1,0", "1,1", "0,1"})
    void notSameValueNotEquals(int diffNumbers, int diffBonusNumbers) {
        // given
        var matchedNumber = 1;
        var matchedBonusNumber = 1;
        var lottoMatchingInfo1 = LottoMatchingInfo
                .builder()
                .matchedNumbers(matchedNumber)
                .matchedBonusNumbers(matchedBonusNumber)
                .build();
        var lottoMatchingInfo2 = LottoMatchingInfo
                .builder()
                .matchedNumbers(matchedNumber + diffNumbers)
                .matchedBonusNumbers(matchedBonusNumber + diffBonusNumbers)
                .build();

        // when
        var actual = lottoMatchingInfo1.equals(lottoMatchingInfo2);

        // then
        Assertions.assertThat(actual).isFalse();
    }
}
