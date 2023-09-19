package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

  @DisplayName("당첨로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void createLottoByOverSize() {
    WinningLotto winningLotto = new WinningLottoImpl();
    assertThatThrownBy(() -> winningLotto.saveWinningNumber("1, 2, 3, 4, 5, 6, 7"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @ParameterizedTest
  @CsvSource(value = {"1, 2, 3, 4, 5, 5", "2, 2, 3, 4, 5, 5"})
  void createLottoByDuplicatedNumber(String testNumbers) {
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    WinningLotto winningLotto = new WinningLottoImpl();
    assertThatThrownBy(() -> winningLotto.saveWinningNumber(testNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호가 1에서 45 사이가 아니면 예외가 발생한다.")
  @ParameterizedTest
  @CsvSource(value = {"1, 2, 3, 4, 5, 0", "1, 2, 3, 4, 5, 46", "1, 2, 3, 4, 5, 90"})
  void 로또번호_1_45_사이인지_판단(String input) {
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    WinningLotto winningLotto = new WinningLottoImpl();
    assertThatThrownBy(() -> winningLotto.saveWinningNumber(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
