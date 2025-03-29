package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    //로또 번호 생성
    public static List<Integer> randomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    //로또 여러장 생성
    public static List<Lotto> buyLottos(int price) {
        int amount = calculateLottoAmount(price);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = randomLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    //로또 구매 갯수 계산
    public static int calculateLottoAmount(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
        return price / LOTTO_PRICE;
    }
}
