package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoTicket {
    private final List<LottoDraws> lottos;

    public LottoTicket(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new LottoDraws(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<LottoDraws> getLottos() {
        return lottos;
    }

    public void printLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoDraws lotto : lottos) {
            System.out.println(lotto);
        }
    }
}