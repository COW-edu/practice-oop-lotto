package model;

import camp.nextstep.edu.missionutils.Randoms;
import valueObject.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNum {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    private ErrorMessage errorMessage;

    // 금액을 입력받고 몇 장을 샀는지 확인하는 메서드
    public int buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(errorMessage.ERROR_PRICE);
        }
        return money / LOTTO_PRICE;
    }
    // 랜덤으로 숫자를 뽑아 리스트에 넣어주는 메서드
    public List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    // String 분리하여 배열에 저장하고 배열을 리턴하는 메서드
    public List<Integer> splitNum(String numbers) {
        List<Integer> result = new ArrayList<>();

        String[] number = numbers.split(",");
        for (String num : number) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }

    public void validate(int bonusNum) {
        if (1 > bonusNum || bonusNum > 45)
            throw new NumberFormatException();
    }
}
