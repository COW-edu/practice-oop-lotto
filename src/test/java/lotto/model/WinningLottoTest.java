package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.WinningLotto;

class WinningLottoTest {

	@DisplayName("1등 로또 번호와 일치하는 경우 1등을 반환한다.")
	@Test
	void matchFirstRank() {
		Lotto playerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 45);
		assertThat(winningLotto.match(playerLotto)).isEqualTo(Ranking.FIRST);
	}

	@DisplayName("보너스 번호와 일치하며 5개 번호가 일치하는 경우 2등을 반환한다.")
	@Test
	void matchSecondRank() {
		Lotto playerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
		assertThat(winningLotto.match(playerLotto)).isEqualTo(Ranking.SECOND);
	}

	@DisplayName("보너스 번호와 일치하지 않으며 5개 번호가 일치하는 경우 3등을 반환한다.")
	@Test
	void matchThirdRank() {
		Lotto playerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
		WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
		assertThat(winningLotto.match(playerLotto)).isEqualTo(Ranking.THIRD);
	}

}
