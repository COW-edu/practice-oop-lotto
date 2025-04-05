package lotto.Model;

import java.util.List;

public interface Buyer {
    void pay(int paidMoney);
    void receiveLotto();
    int getPaidMoney();
    List<Lotto> getMyLotto();
    int getPurchasedLottoCount();
}
