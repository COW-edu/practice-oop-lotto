package view;

import model.lotto.Lotto;

public interface LottoInput {
    int getBonusNumber();
    int getInputMoney();
    Lotto inputNumber();
}
