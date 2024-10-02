package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 입력 받은 번호 리스트의 유효성 검사 후 유효하면 객체로 저장.
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) { // 6개 인지...
            throw new IllegalArgumentException(Rank.ExceptionCode.LOTTO_NUMBER_RULE1.getMessage());
        }

        // Stream을 사용, 번호가 1에서 45 사이에 있는지...
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);

        // 유효하지 않은 번호가 있으면 예외
        if (!isValid) {
            throw new IllegalArgumentException(Rank.ExceptionCode.LOTTO_NUMBER_RULE2.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
