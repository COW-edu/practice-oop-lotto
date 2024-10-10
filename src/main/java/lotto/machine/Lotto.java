package lotto.machine;

import lotto.constant.ErrorMessage;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 유효성 검사를 생성자 내부에서 처리
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    // 보너스 번호 유효성 검사
    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    // 로또 번호 유효성 검사
    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    // 로또 번호 개수 유효성 검사
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_COUNT.getMessage());
        }
    }

    // 숫자 범위 유효성 검사
    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    // 중복 유효성 검사
    private void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    // 로또 번호 반환
    public List<Integer> getNumbers() {
        return numbers;
    }
}
