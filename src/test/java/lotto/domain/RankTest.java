package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이다.")
    @Test
    void secondRankWithBonus() {
        Rank rank = Rank.of(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호만 일치하면 3등이다.")
    @Test
    void thirdRankWithoutBonus() {
        Rank rank = Rank.of(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("2개 이하는 낙첨이다.")
    @Test
    void missRank() {
        Rank rank = Rank.of(2, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
