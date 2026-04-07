package lotto;

import domain.BonusNumber;
import domain.Lotto;
import domain.WinningLotto;
import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningLotto, new BonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또가 null이면 예외가 발생한다.")
    @Test
    void createWinningLottoByNullWinningLotto() {
        assertThatThrownBy(() -> new WinningLotto(null, new BonusNumber(7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 null이면 예외가 발생한다.")
    @Test
    void createWinningLottoByNullBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningLotto, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 5개와 보너스 번호가 일치하면 2등이다.")
    @Test
    void matchSecondRank() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        Rank rank = winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}

