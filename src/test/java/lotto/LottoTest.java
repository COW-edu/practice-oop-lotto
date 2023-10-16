package lotto;

import lotto.domain.Lotto;
import lotto.view.input.InputWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호가 유효하지 않은 범위의 숫자를 포함하면 예외가 발생한다.")
    void enterWinningNumbersWithInvalidRange() {
        // Arrange
        String input = "0,2,3,4,5,46";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();

        // Act and Assert
        assertThatThrownBy(inputWinningNumbers::getValue)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 1 ~ 45 사이의 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 번호 입력이 유효하면 정상적으로 리스트로 반환된다.")
    void enterValidWinningNumbers() {
        String input = "1,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();

        List<Integer> winningNumbers = inputWinningNumbers.getValue();

        assertThat(winningNumbers)
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
