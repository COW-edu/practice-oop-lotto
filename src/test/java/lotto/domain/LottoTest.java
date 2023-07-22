package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

  @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void 로또번호_개수_확인() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @ParameterizedTest
  @CsvSource(value = {"5, 5", "1, 5"})
  void 로또번호_중복_확인(int number1, int number2) {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, number1, number2)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호가 1에서 45 사이가 아니면 예외가 발생한다.")
  @ParameterizedTest
  @CsvSource(value = {"0", "46", "90"})
  void 로또번호_1_45_사이인지_판단(int input) {
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, input)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
