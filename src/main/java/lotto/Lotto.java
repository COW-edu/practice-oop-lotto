package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호입니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
