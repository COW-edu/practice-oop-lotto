package lotto;

import Enum.ErrorMessage;

import java.util.List;

public class Lotto {
    // validate에 필요한 모든 매직 넘버 public으로 처리(RandomLotto, User 클래스에서 사용)
    public final static int PRICE = 1000;
    public static final int COUNT_RANGE = 6;

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOutOfRange(numbers);
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
        checkDuplication(Integer.parseInt(userBonusStr));
        return Integer.parseInt(userBonusStr);
    }

    // 입력받은 보너스 번호 검증
    private void convertBonusNum(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException exception) {
            ErrorMessage.CATCHSTRING.getExceptionMessage();
        }
    }

    // 로또 번호 범위 확인
    public boolean checkOutOfRange(List<Integer> userLottoNumber) {
        for(int i=0; i<userLottoNumber.size();i++) {
            if(userLottoNumber.get(i) < MIN_RANGE || userLottoNumber.get(i) > MAX_RANGE) {
                ErrorMessage.LOTTORANGE.getExceptionMessage();
            }
        }
        return true;
    }

    // 선택한 6개의 숫자와 보너스 숫자 중복 확인 로직
    private boolean checkDuplication(int bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            ErrorMessage.DUPLICATE.getExceptionMessage();
            throw new IllegalArgumentException();
        }
        return true;
    }
}
