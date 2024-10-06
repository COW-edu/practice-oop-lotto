package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);  // TreeSet으로 정렬된 번호 저장
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Constant.ERROR_INVALID_NUMBER);
            }
        }
        if (new TreeSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Constant.ERROR_DUPLICATE_NUMBER);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
