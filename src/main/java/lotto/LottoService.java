package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> generateLotto(int purchaseAmount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        int numberOfLotto = purchaseAmount / LottoInformation.PRICE_PER_LOTTO;
        for (int i = 0; i < numberOfLotto; i++) {
            purchasedLotto.add(Lotto.generate());
        }
        return purchasedLotto;
    }
}
