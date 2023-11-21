package lotto.lottoAppTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.entity.WinLottoListClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    private List<Integer> winLottoList;

    @BeforeEach
    void setBefore() {
        winLottoList = new ArrayList<>();
    }

    @DisplayName("당첨 번호 범위에 안들어오는 값 입력 테스트")
    @Test
    void winLottoTest() {
        String[] numbers = {"101", "2", "3", "4", "5", "6"};

//        assertThatThrownBy(() -> new WinLotto().drawNumber(numbers))
//            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 중복 입력 테스트")
    @Test
    void bonusNumberTest() {
        String[] numbers = {"1", "2", "3", "5", "5"};

//        assertThatThrownBy(() -> new WinLotto().drawNumber(numbers))
//            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 중복 입력 테스트")
    @Test
    void duplicateBonusAndWinNuber() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        winLottoList.addAll(Arrays.asList(numbers));
        Integer bonus = 5;

        assertThatThrownBy(() -> new WinLottoListClass(winLottoList)
            .setBonusNumber(bonus))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
