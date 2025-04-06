package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import static lotto.model.Constants.*;

public class LottoDraw {
    private final List<List<Integer>> lottos;

    public LottoDraw(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, SAVED_LOTTO_NUMBERS));
        }
        printLottos();
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    private void printLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}