package model.service;

import model.lotto.Lotto;

public interface LottoService {
    void lottoCompare(Lotto targetLotto, int bonusNumber);
    void printLotto(int inputMoney);
}
