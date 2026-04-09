package kr.abins.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void calculateProfitRate() {
        // Given: 8,000원을 투자하여 5,000원(5등) 한 번 당첨된 경우
        final Map<LottoPrize, List<LottoReceipt>> recipes = new HashMap<>();
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        recipes.put(LottoPrize.PRIZE_5TH, List.of(new LottoReceipt(lotto, LottoPrize.PRIZE_5TH)));
        final ArrayList<LottoReceipt> nones = new ArrayList<>();
        for (int index = 0; index < 7; ++index) {
            nones.add(new LottoReceipt(lotto, LottoPrize.NONE_0));
        }
        recipes.put(LottoPrize.NONE_0, nones);

        final LottoResult result = new LottoResult(recipes);


        // When: 수익률 계산 (5000 / 8000 * 100 = 62.5%)
        double profitRate = result.profitRate();

        // Then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("구입 금액이 0원일 때 수익률은 0이다.")
    @Test
    void calculateProfitRateZeroAmount() {
        LottoResult result = new LottoResult(new HashMap<>());
        assertThat(result.profitRate()).isEqualTo(0);
    }

    @DisplayName("각 등수의 당첨 횟수를 올바르게 반환한다.")
    @Test
    void count() {
        Map<LottoPrize, List<LottoReceipt>> recipes = new HashMap<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        recipes.put(LottoPrize.PRIZE_5TH, List.of(new LottoReceipt(lotto, LottoPrize.PRIZE_5TH), new LottoReceipt(lotto, LottoPrize.PRIZE_5TH)));
        
        LottoResult result = new LottoResult(recipes);

        assertThat(result.count(LottoPrize.PRIZE_5TH)).isEqualTo(2);
        assertThat(result.count(LottoPrize.PRIZE_1ST)).isEqualTo(0);
    }
}
