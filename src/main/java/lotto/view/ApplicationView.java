package lotto.view;

import lotto.lotto.domain.Lotto;

import java.util.List;

public interface ApplicationView {

    void printListLotto(List<Lotto> purchasedLotto);

    void printListLottoReward(List<Lotto> listResult);

    void printErrorMessage(String message);

    int getPurchasedPrice();

    List<Integer> getWinningNumbers();

    int getBonusNumber();

}
