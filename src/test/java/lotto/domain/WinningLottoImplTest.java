package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoImplTest {

  @DisplayName("보너스 번호를 제외한 당첨번호와 입력받은 로또의 번호를 비교하여 맞춘 로또의 수를 계산한다.")
  @ParameterizedTest
  @MethodSource("generateData")
  public void calculateWinningCount(List<Integer> lottoList, int winningCount) {
    // given
    WinningLotto winningLotto = new WinningLottoImpl();

    // when
    winningLotto.saveWinningNumber("1,2,3,4,5,6");

    // then
    assertThat(winningLotto.calculateWinningCount(lottoList)).isEqualTo(winningCount);
  }

  static Stream<Arguments> generateData() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
        Arguments.of(Arrays.asList(11, 2, 31, 4, 51, 6), 3),
        Arguments.of(Arrays.asList(10, 20, 30, 7, 5, 6), 2),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9), 5)
    );
  }
}