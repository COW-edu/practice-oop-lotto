package lotto;

import Enum.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    // 매직 넘버
    private static final int startRange = 1;
    private static final int endRange = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
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
    public boolean checkOutOfRange(Lotto userLottoNumber) {
        List<Integer> userLottoNum = userLottoNumber.getLottoNumbers();
        for(int i=0; i<userLottoNum.size();i++) {
            if(userLottoNum.get(i) < startRange || userLottoNum.get(i) > endRange) {
                ErrorMessage.LOTTORANGE.getExceptionMessage();
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    // 선택한 6개의 숫자와 보너스 숫자 중복 확인 로직
    public boolean checkDuplication(Lotto selectNumber, int bonusNumber) {
        List<Integer> selectLottoNum = selectNumber.getLottoNumbers();
        if(selectLottoNum.contains(bonusNumber)) {
            ErrorMessage.DUPLICATE.getExceptionMessage();
            throw new IllegalArgumentException();
        }
        return true;
    }
}
