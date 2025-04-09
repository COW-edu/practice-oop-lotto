package view;

import dto.LottoDto;
import model.constants.WinningRank;

import java.util.List;
import java.util.Map;

public interface OutputView {
    void printPurchaseCount(int count);

    void printLottoNumbers(List<LottoDto> lottoNumbers);

    void printWinningResult(Map<WinningRank, Integer> result);

    void printProfitRate(float profitRate);
}
