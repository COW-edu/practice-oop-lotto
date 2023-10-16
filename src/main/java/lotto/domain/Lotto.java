package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] : 6개의 번호를 입력하시오.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        numbers.stream()
                .filter(number -> !uniqueNumbers.add(number))
                .findAny()
                .ifPresent(duplicateNumber -> {
                    throw new IllegalArgumentException("[ERROR] : 로또 번호에 중복된 숫자가 있습니다.");
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}