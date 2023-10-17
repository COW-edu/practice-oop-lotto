package lotto.logic;

import static lotto.constant.LottoRule.LOTTO_COUNT_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoRule.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.entity.Lotto;

public class LottoMachine {
    
    private final ArrayList<Lotto> lottoLists;

    public LottoMachine() {
        lottoLists = new ArrayList<>();
    }

    public ArrayList<Lotto> playLotto(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoRow = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER, LOTTO_COUNT_NUMBER);
            sort(lottoRow);
            Lotto lotto = new Lotto(lottoRow);
            lottoLists.add(lotto);
        }
        return lottoLists;
    }

    public static void sort(List<Integer> lottoRow) {
        for (int i = 0; i < LOTTO_ROW_SIZE; i++) {
            for (int j = i + 1; j < LOTTO_ROW_SIZE; j++) {
                if (lottoRow.get(i) > lottoRow.get(j)) {
                    int tmp = lottoRow.get(i);
                    lottoRow.set(i, lottoRow.get(j));
                    lottoRow.set(j, tmp);
                }
            }
        }
    }
}
