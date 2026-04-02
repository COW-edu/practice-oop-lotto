package kr.abins.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("당첨 번호와 보너스 번호에 따라 올바른 등수를 찾는다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, PRIZE_1ST",
            "5, true, PRIZE_2ND",
            "5, false, PRIZE_3RD",
            "4, false, PRIZE_4TH",
            "3, false, PRIZE_5TH"
    })
    void findPrize(int correctCount, boolean bonusMatch, String expectedPrizeName) {
        LottoPrize expectedPrize = LottoPrize.valueOf(expectedPrizeName);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // Mock Lotto behavior via matching numbers
        List<Integer> lottoNumbers;
        if (correctCount == 6) {
            lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        } else if (correctCount == 5 && bonusMatch) {
            lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        } else if (correctCount == 5 && !bonusMatch) {
            lottoNumbers = List.of(1, 2, 3, 4, 5, 8);
        } else if (correctCount == 4) {
            lottoNumbers = List.of(1, 2, 3, 4, 8, 9);
        } else { // 3
            lottoNumbers = List.of(1, 2, 3, 8, 9, 10);
        }

        Lotto lotto = new Lotto(lottoNumbers);
        Optional<LottoPrize> prize = LottoPrize.find(winningNumbers, bonus, lotto);

        assertThat(prize).isPresent();
        assertThat(prize.get()).isEqualTo(expectedPrize);
    }
}
