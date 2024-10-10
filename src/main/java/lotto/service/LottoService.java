package lotto.service;

import lotto.model.Lotto;
import java.util.List;

public interface LottoService {

    void purchaseLottos(int amount);

    void saveLottoNums(Lotto lottoNums);

    void inputWinningNumbers(List<Integer> winningNumbers, int bonusNumber);

    void checkAndPrintResults();
}
