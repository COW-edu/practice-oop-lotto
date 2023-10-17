package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingTest {

	@DisplayName("6개 일치 시 1등 반환")
	@Test
	void firstRank() {
		assertThat(Ranking.valueOf(6, false)).isEqualTo(Ranking.FIRST);
	}

	@DisplayName("5개 일치 및 보너스 볼 일치 시 2등 반환")
	@Test
	void secondRankWithBonus() {
		assertThat(Ranking.valueOf(5, true)).isEqualTo(Ranking.SECOND);
	}

	@DisplayName("5개 일치 및 보너스 볼 불일치 시 3등 반환")
	@Test
	void thirdRankWithoutBonus() {
		assertThat(Ranking.valueOf(5, false)).isEqualTo(Ranking.THIRD);
	}

	@DisplayName("4개 일치 시 4등 반환")
	@Test
	void fourthRank() {
		assertThat(Ranking.valueOf(4, false)).isEqualTo(Ranking.FOURTH);
	}

	@DisplayName("3개 일치 시 5등 반환")
	@Test
	void fifthRank() {
		assertThat(Ranking.valueOf(3, false)).isEqualTo(Ranking.FIFTH);
	}

	@DisplayName("2개 이하 일치 시 MISS 반환")
	@Test
	void missRank() {
		assertThat(Ranking.valueOf(2, false)).isEqualTo(Ranking.MISS);
	}

	@DisplayName("유효하지 않은 매칭 개수 입력 시 예외 발생")
	@Test
	void invalidMatchCount() {
		assertThatThrownBy(() -> Ranking.valueOf(7, false))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
