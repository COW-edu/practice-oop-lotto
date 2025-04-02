package view;

import model.Lotto;
import model.WinningRank;

import java.util.List;
import java.util.Map;

public interface Output {
    void printPurchaseCount(int count);

    void printLottoNumbers(List<Lotto> lottoNumbers);

    void printWinningResult(Map<WinningRank, Integer> result);

    void printProfitRate(float profitRate);
}
