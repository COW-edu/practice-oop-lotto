package lotto.logic;

import static lotto.constant.LottoRule.LOTTO_COUNT_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.entity.Lotto;

public class LottoMachineImpl implements LottoMachine {

    private final ArrayList<Lotto> lottoLists;

    public LottoMachineImpl() {
        lottoLists = new ArrayList<>();
    }

    public ArrayList<Lotto> playLotto(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoRow = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER, LOTTO_COUNT_NUMBER);
            Collections.sort(lottoRow);
            Lotto lotto = new Lotto(lottoRow);
            lottoLists.add(lotto);
        }
        return lottoLists;
    }

}
