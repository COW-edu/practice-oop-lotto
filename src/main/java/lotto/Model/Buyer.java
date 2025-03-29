package lotto.Model;

import java.util.List;

public interface Buyer {
    void purchaseMoney(int purchasingMoney);
    void getLotto();
    int getPurchasingMoney();
    List<Lotto> showMyLotto();
    int getPurchasedLotto();
}
