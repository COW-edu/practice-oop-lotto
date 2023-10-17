package controller;

import model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @ParameterizedTest
    @DisplayName("보너스 번호가 잘못되면 예외가 발생한다")
    @ValueSource(ints = {1, 100})
    void createBonusByWrongForm(int bonus) {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
