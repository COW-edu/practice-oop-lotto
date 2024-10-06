package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    // 금액을 입력받고 몇 장을 샀는지 확인하는 메서드
    public int buy(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }
    // 랜덤으로 숫자를 뽑아 리스트에 넣어주는 메서드
    public List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
//    // 구매한 로또 번호들을 리스트 안에 넣어주는 메서드
//    public List<List<Integer>> createList(int count, List<Integer> lotto) {
//        for (int i = 0; i < count; i++) {
//            lottos.add(lotto);
//        }
//        return lottos;
//    }
    public void validate(int bonusNum) {
        if (1 > bonusNum || bonusNum > 45)
            throw new NumberFormatException();
    }
//    public List<List<Integer>> getLottos() {
//        return lottos;
//    }
}
