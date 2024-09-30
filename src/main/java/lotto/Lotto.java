package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Rank.ExceptionCode.LOTTO_NUMBER_RULE1.getMessage());
        }

        // Stream을 사용
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);

        if (!isValid) {
            throw new IllegalArgumentException(Rank.ExceptionCode.LOTTO_NUMBER_RULE2.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
