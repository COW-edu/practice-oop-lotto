package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {
    @DisplayName("구입 금액을 숫자로 파싱한다.")
    @Test
    void parsePurchaseAmount() {
        int purchaseAmount = InputParser.parsePurchaseAmount("8000");
        assertThat(purchaseAmount).isEqualTo(8000);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void parsePurchaseAmountByInvalidUnit() {
        assertThatThrownBy(() -> InputParser.parsePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위");
    }

    @DisplayName("당첨 번호를 파싱한다.")
    @Test
    void parseWinningNumbers() {
        List<Integer> numbers = InputParser.parseWinningNumbers("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호 범위가 벗어나면 예외가 발생한다.")
    @Test
    void parseWinningNumbersByOutOfRange() {
        assertThatThrownBy(() -> InputParser.parseWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void parseBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> InputParser.parseBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }
}
