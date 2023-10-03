package lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private List<Lotto> purchasedLottoList;

    public PurchasedLotto(int amountOfLotto) {
        purchasedLottoList = new ArrayList<>();
        for (int i = 0; i < amountOfLotto; i++) {
            purchasedLottoList.add(LottoMaking.MakeLotto());
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLottoList;
    }
}

