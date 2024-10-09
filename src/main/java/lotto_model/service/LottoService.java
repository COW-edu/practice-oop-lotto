package lotto_model.service;

import lotto_model.lotto.Lotto;

public interface LottoService {
    void lottoCompare(Lotto targetLotto, int bonusNumber);
    void printLotto(int inputMoney);
}
