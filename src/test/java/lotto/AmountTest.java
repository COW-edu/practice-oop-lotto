package lotto;

import domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmountTest {

    @DisplayName("입력값이 음수인 경우")
    @Test
    void createAmountMinus() {
        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1,000원 단위가 아닌 경우")
    @Test
    void createAmountWithNumber() {
        assertThatThrownBy(() -> new PurchaseAmount(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 금액이 입력되면 로또 발행 수량을 정확히 계산한다.")
    @Test
    void calculateTicketCount() {
        PurchaseAmount amount = new PurchaseAmount(5000);
        assertThat(amount.getLottoCount()).isEqualTo(5);
    }
}
