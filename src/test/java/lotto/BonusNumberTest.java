package lotto;

import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("입력값이 숫자가 아닌 경우")
    @Test
    void createAmountNotNumber() {
        assertThatThrownBy(() -> new Amount("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 1 ~ 45 범위가 아닌 경우.")
    @Test
    void createLottoByNotRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

    }
     @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우")
     @Test
     void createBonusNumberByDuplicatedWinningNumber() {
         Lotto winningLotto = new Lotto("1,2,3,4,5,6");

         assertThatThrownBy(() -> new BonusNumber("6", winningLotto))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessage(ErrorMessage.ErrorMessageType.LOTTO_NUMBER_DUPLICATED.getMessage());
     }
}
