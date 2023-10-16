package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoTest {

    @Test
    void testConstructor() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertNotNull(lotto);
        assertEquals(numbers, lotto.getNumbers());
    }

    @Test
    void testValidate_Lotto_ValidLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertDoesNotThrow(lotto::validate_Lotto);
    }
}
