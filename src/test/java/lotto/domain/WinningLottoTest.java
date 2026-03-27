package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberShouldNotBeDuplicated() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningLotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void matchSecondRank() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
