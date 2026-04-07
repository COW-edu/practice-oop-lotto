package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import java.util.*;

public class LottoService {

    private static final int PRICE = 1000;

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);
        int count = money / PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private void validateMoney(int money) {
        if (money % PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}