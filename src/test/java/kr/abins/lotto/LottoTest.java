package kr.abins.lotto;

import kr.abins.lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정상적이면 예외가 발생하지 않는다.")
    @Test
    void createLotto() {
        new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수를 반환한다.")
    @Test
    void countCorrectNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);

        assertThat(lotto.correct(winningNumbers)).isEqualTo(3);
    }

    @DisplayName("당첨 번호가 하나도 일치하지 않는 경우 0을 반환한다.")
    @Test
    void countCorrectNumbersZero() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);

        assertThat(lotto.correct(winningNumbers)).isEqualTo(0);
    }

    @DisplayName("보너스 번호 포함 여부를 확인한다.")
    @Test
    void checkBonusMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.bonusMatch(6)).isTrue();
        assertThat(lotto.bonusMatch(7)).isFalse();
    }
}