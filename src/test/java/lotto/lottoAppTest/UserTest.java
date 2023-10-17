package lotto.lottoAppTest;

import static lotto.constant.LottoRule.LOTTO_ONE_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @BeforeEach
    void setBefore() {

    }

    @Test
    @DisplayName("입력한 금액가 단위에 맞는 지 테스트")
    void checkInputMoney() {
        int inputMoney = 10004;

        assertThatThrownBy(() -> new User().setBudget(inputMoney))
            .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] " + LOTTO_ONE_PRICE + "원으로 나뉘어 떨어져야합니다.");
    }
}
