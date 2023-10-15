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
        // TODO checkOutOfRange 함수 테스트
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

    // 검증 후 반환
    public int userBonusNum(String userBonusStr) {
        convertBonusNum(userBonusStr);
        checkDuplicateBonus(Integer.parseInt(userBonusStr));
        return Integer.parseInt(userBonusStr);
    }

    // 입력받은 보너스 번호 검증
    private void convertBonusNum(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            ErrorMessage.CATCHSTRING.announceException();
        }
    }

    // 로또 번호 범위 확인
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

    // 선택한 6개의 숫자와 보너스 숫자 중복 확인 로직
    private boolean checkDuplicateBonus(int bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            ErrorMessage.DUPLICATEBONUS.announceException();
            throw new IllegalArgumentException();
        }
        return true;
    }
}
