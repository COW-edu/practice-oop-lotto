package lotto.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottosFactory {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer PICK_NUMBER_OF_LOTTO = 6;
    private static final Integer LOTTO_PRICE = 1000;

    public List<Lotto> makeLottos(Money money) {

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < getLottoCount(money); i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER_OF_LOTTO);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    private int getLottoCount(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
