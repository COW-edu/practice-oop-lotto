package Model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    void validateSize_ValidSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateSize(numbers));
    }

    @Test
    void validateSize_InvalidSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateSize(numbers));
        assertEquals("[ERROR] 로또 번호는 6개 입니다.", exception.getMessage());
    }

    @Test
    void validateRange_ValidRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateRange(numbers));
    }

    @Test
    void validateRange_InvalidRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 46, 47);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateRange(numbers));
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void validateDuplicate_NoDuplicates() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateDuplicate(numbers));
    }

    @Test
    void validateDuplicate_WithDuplicates() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicate(numbers));
        assertEquals("[ERROR] 중복되는 숫자가 포함되어 있습니다", exception.getMessage());
    }

    @Test
    void validateMoney_ValidMoney() {
        String money = "2000";
        assertDoesNotThrow(() -> Validator.validateMoney(money));
    }

    @Test
    void validateMoney_InvalidMoney() {
        String money = "1500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateMoney(money));
        assertEquals("[ERROR] 입력한 금액은 1000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    void validateBonus_ValidBonus() {
        String bonusNum = "7";
        assertDoesNotThrow(() -> Validator.validateBonus(bonusNum));
    }

    @Test
    void validateBonus_InvalidBonusOutOfRange() {
        String bonusNum = "50";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBonus(bonusNum));
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void validateBonus_InvalidBonusNonNumeric() {
        String bonusNum = "abc";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBonus(bonusNum));
        assertEquals("[ERROR] 보너스 번호를 숫자로 입력해야 합니다.", exception.getMessage());
    }
}