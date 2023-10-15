package Model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchasedLotto {
    private static List<Lotto> purchasedLottoList;

    public PurchasedLotto(int amountOfLotto) {
        purchasedLottoList = IntStream.range(0, amountOfLotto)
                .mapToObj(i -> LottoFactory.makeLotto())
                .collect(Collectors.toList());
    }

    public static List<Lotto> getPurchasedLotto() {
        return Collections.unmodifiableList(purchasedLottoList);
    }
}

