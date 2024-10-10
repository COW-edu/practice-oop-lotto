package view;

import java.util.List;
import java.util.Map;

public interface OutputView {
    void displayLottoCount(int lottoCount);
    void displayLottoNumber(List<List<Integer>> lottos);
    void displayWinningList(Map<Integer, Integer> matchCountStatistics);
    void displayReturn(double rateReturn);
}
