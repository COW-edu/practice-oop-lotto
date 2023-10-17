package lotto;

import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구매 금액이 1000원 단위인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    void userLottoNumber(String money) {
        // Given
        User user = new User();

        // When
        int count = user.lottoCount(money);

        // Then
        assertNotEquals(0, count);
        System.out.println("해당 금액은 1000원 단위입니다.");
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아닌 경우를 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"100", "200", "500", "1500"})
    void lottoMoneyException(String money) {

        assertThatThrownBy(() -> new User().lottoCount(money)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 구매 금액이 1000원 이하인 경우 예외가 발생한다.")
    @Test
    void priceException() {
        // Given
        User user = new User();

        // When & Then
        assertThatThrownBy(() -> user.lottoCount("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("선택한 로또 번호가 범위를 벗어난 경우 예외 처리")
    @Test
    void checkOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("선택한 로또 번호와 보너스 번호가 중복인 경우 예외가 발생한다.")
    @Test
    void checkDuplicateBonusNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).userBonusNum("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
