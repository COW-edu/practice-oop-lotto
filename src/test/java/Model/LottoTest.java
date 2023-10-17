package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class LottoTest {
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6, 7",
            "11, 12, 13, 14, 15, 16, 17"
    })
    @DisplayName("잘못된 로또 번호가 들어올 경우 확인")
    void testInvalidLottoNumbers(int num1, int num2, int num3, int num4, int num5, int num6, int num7) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6, num7);
        Lotto lotto = new Lotto(numbers);
        try {
            lotto.validate_Lotto();
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
            return;
        }
        throw new AssertionError("예외가 발생하지 않음");
    }
}

