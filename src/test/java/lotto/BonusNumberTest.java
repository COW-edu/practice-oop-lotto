package lotto;

import domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 1 ~ 45 범위가 아닌 경우")
    @Test
    void createBonusNumberByNotRange() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 1보다 작은 경우")
    @Test
    void createBonusNumberByBelowMin() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
