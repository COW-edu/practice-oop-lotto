package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserNumber {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String SPLITER = ",";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int MIN_PRICE = 0;


//    // 구매한 로또 번호들을 리스트 안에 넣어주는 메서드
//    public List<List<Integer>> createList(int count, List<Integer> lotto) {
//        for (int i = 0; i < count; i++) {
//            lottos.add(lotto);
//        }
//        return lottos;
//    }

//    public List<List<Integer>> getLottos() {
//        return lottos;
//    }
    // 금액을 입력받고 몇 장을 샀는지 확인하는 메서드
    public int buy(int money) {
        if (money % LOTTO_PRICE != MIN_PRICE) {
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }
    // 랜덤으로 숫자를 뽑아 리스트에 넣어주는 메서드
    public List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_SIZE);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }



}
