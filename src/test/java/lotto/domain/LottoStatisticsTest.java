package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @DisplayName("등수별 당첨 개수와 총 당첨 금액을 계산한다.")
    @Test
    void calculateTotalPrize() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.add(Rank.FIFTH);
        statistics.add(Rank.FOURTH);
        statistics.add(Rank.MISS);

        long totalPrize = statistics.calculateTotalPrize();

        assertThat(statistics.getCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(totalPrize).isEqualTo(55_000);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.add(Rank.FIFTH);
        statistics.add(Rank.FOURTH);

        double profitRate = statistics.calculateProfitRate(10_000);

        assertThat(profitRate).isEqualTo(550.0);
    }
}
