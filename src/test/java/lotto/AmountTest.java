package lotto;

import domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmountTest {

    @DisplayName("입력값이 숫자가 아닌 경우")
    @Test
    void createAmountNotNumber() {
        assertThatThrownBy(() -> new Amount("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1,000원 단위가 아닌 경우")
    @Test
    void createAmountWithNumber() {
    assertThatThrownBy(() -> new Amount("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수인 경우")
    @Test
    void createAmountMinus() {
        assertThatThrownBy(() -> new Amount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("정상적인 금액이 입력되면 로또 발행 수량을 정확히 계산한다.")
    @Test
    void calculateTicketCount() {
        Amount amount = new Amount("5000");
        assertThat(amount.getLottoCount()).isEqualTo(5);
    }
}
