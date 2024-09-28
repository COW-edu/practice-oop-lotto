package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculateSheet {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    // 금액을 입력받고 몇 장을 샀는지 확인하는 메서드
    public int buyLotto(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money/LOTTO_PRICE;
    }

    // 랜덤으로 숫자를 뽑아 리스트에 넣어주는 메서드
    public List<Integer> lottoNumbers() {
        List<Integer> randNum = new ArrayList<Integer>();
        Random random = new Random();

        for (int j = 0; j < LOTTO_SIZE; j++) {
                randNum.add(random.nextInt(LOTTO_PRICE));
        }
        return randNum;
    }

}
