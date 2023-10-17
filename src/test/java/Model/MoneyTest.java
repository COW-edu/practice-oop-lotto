package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest{
        private Money money;

        @BeforeEach
        void setUp() {
            money = new Money("5000");
        }
    @ParameterizedTest
    @ValueSource(strings = {"-500", "abc", "100.50", "10001"})
    @DisplayName("입력할 금액이 비정상적인 경우 예외 발생 확인")
    void testInvalidMoneyInput(String inputMoney) {
        try {
            money.validate_Money(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }
        throw new AssertionError("예외가 발생하지 않음");
    }
}