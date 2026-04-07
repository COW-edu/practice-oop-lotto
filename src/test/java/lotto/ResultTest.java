package lotto;

import domain.BonusNumber;
import domain.Lotto;
import domain.Result;
import domain.WinningLotto;
import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("당첨 내역을 등수별로 집계한다.")
    @Test
    void calculateRankCount() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winning = new WinningLotto(winningLotto, bonusNumber);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 11, 12, 13)),
                new Lotto(List.of(8, 9, 10, 11, 12, 14)),
                new Lotto(List.of(15, 16, 17, 18, 19, 20)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26)),
                new Lotto(List.of(27, 28, 29, 30, 31, 32)),
                new Lotto(List.of(33, 34, 35, 36, 37, 38)),
                new Lotto(List.of(39, 40, 41, 42, 43, 44)),
                new Lotto(List.of(8, 9, 10, 20, 30, 45))
        );

        Result result = new Result(purchasedLottos, winning);

        assertThat(result.getCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(0);
    }

    @DisplayName("수익률을 소수점 첫째 자리까지 계산한다. (둘째 자리에서 반올림)")
    @Test
    void calculateReturnRate() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winning = new WinningLotto(winningLotto, bonusNumber);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 11, 12, 13)), // FIFTH 1개 -> 5,000원
                new Lotto(List.of(8, 9, 10, 11, 12, 14)),
                new Lotto(List.of(15, 16, 17, 18, 19, 20)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26)),
                new Lotto(List.of(27, 28, 29, 30, 31, 32)),
                new Lotto(List.of(33, 34, 35, 36, 37, 38)),
                new Lotto(List.of(39, 40, 41, 42, 43, 44)),
                new Lotto(List.of(8, 9, 10, 20, 30, 45))
        );

        Result result = new Result(purchasedLottos, winning);

        assertThat(result.getReturnRate()).isEqualTo(62.5);
    }

    @DisplayName("구매한 로또 목록이 null이면 예외가 발생한다.")
    @Test
    void createResultByNullPurchasedLottos() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winning = new WinningLotto(winningLotto, new BonusNumber(7));

        assertThatThrownBy(() -> new Result(null, winning))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 정보가 null이면 예외가 발생한다.")
    @Test
    void createResultByNullWinningLotto() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> new Result(purchasedLottos, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
