package kr.abins.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void calculateProfitRate() {
        // Given: 8,000원을 투자하여 5,000원(5등) 한 번 당첨된 경우
        Map<LottoPrize, List<LottoRecipe>> recipes = new HashMap<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        recipes.put(LottoPrize.PRIZE_5TH, List.of(new LottoRecipe(lotto, LottoPrize.PRIZE_5TH)));
        
        LottoResult result = new LottoResult(recipes, 8000);

        // When: 수익률 계산 (5000 / 8000 * 100 = 62.5%)
        double profitRate = result.calculateProfitRate();

        // Then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("구입 금액이 0원일 때 수익률은 0이다.")
    @Test
    void calculateProfitRateZeroAmount() {
        LottoResult result = new LottoResult(new HashMap<>(), 0);
        assertThat(result.calculateProfitRate()).isEqualTo(0);
    }

    @DisplayName("각 등수의 당첨 횟수를 올바르게 반환한다.")
    @Test
    void getCount() {
        Map<LottoPrize, List<LottoRecipe>> recipes = new HashMap<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        recipes.put(LottoPrize.PRIZE_5TH, List.of(new LottoRecipe(lotto, LottoPrize.PRIZE_5TH), new LottoRecipe(lotto, LottoPrize.PRIZE_5TH)));
        
        LottoResult result = new LottoResult(recipes, 2000);

        assertThat(result.getCount(LottoPrize.PRIZE_5TH)).isEqualTo(2);
        assertThat(result.getCount(LottoPrize.PRIZE_1ST)).isEqualTo(0);
    }
}
