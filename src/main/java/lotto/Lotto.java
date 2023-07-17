package lotto;

import lotto.validation.LotteryNumberValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LotteryNumberValidator.validateLottoNumbers(numbers);
        LotteryNumberValidator.checkDuplicate(numbers);
        Collections.sort(numbers); // 오름차순 정렬
        this.numbers = numbers;
    }
//    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException();
//        }
//    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
