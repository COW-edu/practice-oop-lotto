package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;
    private static final Integer PICK_NUMBER_OF_LOTTO = 6;
    private List<Integer> lottoNumbers;
    private List<Lotto> lottos = new ArrayList<>();
    public List<Lotto> makeLottos(Money money) {
        for(int i = 0; i < money.getCount(); i++) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, PICK_NUMBER_OF_LOTTO);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }
}
