package lotto.domain;

import lotto.utils.LottoConstants;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT || new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(LottoConstants.LOTTO_ERROR);
        }
    }
}
