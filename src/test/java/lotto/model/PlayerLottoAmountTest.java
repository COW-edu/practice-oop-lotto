package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerLottoAmountTest {
	@DisplayName("올바른 로또 개수를 반환한다.")
	@Test
	void validLottoCount() {
		PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount("2000");
		int count = playerLottoAmount.calculateLottoCount();
		assertThat(count).isEqualTo(2);
	}

	@DisplayName("숫자가 아닌 금액이면 예외가 발생한다.")
	@Test
	void invalidNumberInput() {
		assertThatThrownBy(() -> new PlayerLottoAmount("로또"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("음수 금액이면 예외가 발생한다.")
	@Test
	void negativeAmount() {
		assertThatThrownBy(() -> new PlayerLottoAmount("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("금액이 0이면 예외가 발생한다.")
	@Test
	void zeroAmount() {
		assertThatThrownBy(() -> new PlayerLottoAmount("0"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1000으로 나누어 떨어지지 않는 금액이면 예외가 발생한다.")
	@Test
	void amountNotDivisibleByThousand() {
		assertThatThrownBy(() -> new PlayerLottoAmount("1500"))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
