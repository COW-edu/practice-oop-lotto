package view;

import model.Lotto;

import java.util.List;
import java.util.Map;

public interface Output {
    void printPurchaseCount(int count);

    void printLottoNumbers(List<Lotto> lottoNumbers);

    void printWinningResult(Map<String, Integer> result);

    void printProfitRate(float profitRate);
}
