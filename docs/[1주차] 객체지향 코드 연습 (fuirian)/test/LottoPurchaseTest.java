package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @DisplayName("로또 구매 금액 예외 테스트")
    @Test
    public void testLottoPurchaseAmount() {
        // given
        LottoPurchase lottoPurchase = new LottoPurchase();

        // when and then
        assertThatThrownBy(() -> lottoPurchase.setPurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 이상의 금액을 입력해야 합니다.");

        assertThatThrownBy(() -> lottoPurchase.setPurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 이상의 금액을 입력해야 합니다.");
    }
}

class LottoPurchase {
    private int purchaseAmount;

    public void setPurchaseAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해야 합니다.");
        }
        this.purchaseAmount = amount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

