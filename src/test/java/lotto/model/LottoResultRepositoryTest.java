package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultRepositoryTest {

  @DisplayName("로또 결과 저장이 정상적으로 작동하는지 확인")
  @ParameterizedTest
  @CsvSource(value = {"5, false, 2", "5, true, 3", "3, false, 0", "4, true, 1"})
  public void saveLotto(int winningCount, boolean isBonus, int winningIndex) {
    // given
    LottoResultRepositoryImpl lottoResultRepository = new LottoResultRepositoryImpl();

    // when
    lottoResultRepository.saveLottoResult(winningCount, isBonus);
    int findIndex = lottoResultRepository.findLottoResults().indexOf(1);

    // then
    assertThat(findIndex).isEqualTo(winningIndex);
  }
}