package lotto;

import Enum.ErrorMessage;
import java.util.List;

public class Lotto {
    public final static int PRICE = 1000;
    public static final int COUNT_RANGE = 6;

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOutOfRange(numbers);
        checkDuplicateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public void userBonusNum(int userBonusStr) {
        checkDuplicateBonus(userBonusStr);
    }

    public void checkOutOfRange(List<Integer> userLottoNumber) {
        boolean range = userLottoNumber.stream()
                            .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE);
        if(range) {
            ErrorMessage.LOTTORANGE.announceException();
            throw new IllegalArgumentException();
        }
    }

    private boolean checkDuplicateLotto(List<Integer> lottoNumbers) {
        int duplicate = (int) lottoNumbers.stream()
                .distinct()
                .count();
        if(duplicate != lottoNumbers.size()) {
            ErrorMessage.DUPLICATE.announceException();
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkDuplicateBonus(int bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            ErrorMessage.DUPLICATEBONUS.announceException();
            throw new IllegalArgumentException();
        }
        return true;
    }
}
