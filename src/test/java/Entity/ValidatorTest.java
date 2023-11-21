package Entity;

import Service.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @DisplayName("로또번호의 갯수가 6개가 아닌 경우 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "10,20,30,40,50,60,70", "12,19,32,45"})
    void validateSize_InvalidSize(String invalidNumbers) {
        String[] numbersArray = invalidNumbers.split(",");
        List<Integer> numbers = Arrays.stream(numbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateSize(numbers));
        assertEquals("[ERROR] 로또 번호는 6개 입니다.", exception.getMessage());
    }

    @DisplayName("로또번호의 범위가 1~45가 아닐 경우 확인")
    @Test
    void validateRange_InvalidRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 46, 47);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateRange(numbers));
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또번호가 중복인 경우 확인")
    @Test
    void validateDuplicate_WithDuplicates() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicate(numbers));
        assertEquals("[ERROR] 중복되는 숫자가 포함되어 있습니다", exception.getMessage());
    }

    @DisplayName("입력한 금액이 1000원 단위로 나누어 떨어지지 않는 경우 확인")
    @Test
    void validateMoney_InvalidMoney() {
        String money = "1500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateMoney(money));
        assertEquals("[ERROR] 입력한 금액은 1000원 단위여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 범위 밖일 경우 확인")
    @Test
    void validateBonus_InvalidBonusOutOfRange() {
        String bonusNum = "50";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBonus(bonusNum));
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 확인")
    @Test
    void validateBonus_InvalidBonusNonNumeric() {
        String bonusNum = "abc";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBonus(bonusNum));
        assertEquals("[ERROR] 보너스 번호를 숫자로 입력해야 합니다.", exception.getMessage());
    }
}