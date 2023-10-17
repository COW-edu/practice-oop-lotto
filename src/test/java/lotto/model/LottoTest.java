package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 6개 미만이면 예외가 발생한다.")
	@Test
	void createLottoByUnderSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 유효 범위(1-45)를 벗어나면 예외가 발생한다.")
	@Test
	void createLottoByInvalidNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("두 로또 간 일치하는 번호 수를 계산한다.")
	@Test
	void countMatchingNumbers() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

		int count = lotto.countMatch(winningLotto);
		assertThat(count).isEqualTo(3);
	}
}
