package model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  // 아래에 추가 테스트 작성 가능

  @DisplayName("로또 번호가 1~45범위를 벗어나면 예외가 발생한다.")
  @Test
  void createLottoByOverRange() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("주어진 번호가 로또의 번호리스트와 같은 값이 있으면 true, 없으면 false를 반환한다.")
  @Test
  void checkEqualNumber() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Assertions.assertThat(lotto.checkEqualNumber(3)).isEqualTo(true);

  }

  @DisplayName("주어진 리스트 값들과 로또의 번호리스트의 값들을 비교하여 서로 값이 같은 개수를 반환해준다.")
  @Test
  void checkEqualNumbersCount() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> list2 = List.of(4, 5, 6, 7, 8, 9);
    Assertions.assertThat(lotto.checkEqualNumbersCount(list2)).isEqualTo(3);
  }
}
