package lotto_view;

import lotto_model.lotto.Lotto;

public interface LottoInput {
    int getBonusNumber();
    int getInputMoney();
    Lotto inputNumber();
}
