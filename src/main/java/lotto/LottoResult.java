package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
  private List<WinningCondition> winningConditions;
  private LottoInput lottoInput;
  private LottoManager lottoManager;
  private Map<WinningCondition, Integer> resultMap; // 등수별 몇 번 당첨인지 확인

  public LottoResult(LottoManager lottoManager) {
    this.lottoManager = lottoManager;
    this.lottoInput = LottoInput.askWinningDetails();
    this.resultMap = new HashMap<>();
    checkAllLottos();
  }

  private void checkAllLottos() {
    List<Lotto> lottos = lottoManager.getLottos();
    for (Lotto lotto : lottos) {
      WinningCondition condition = checkLotto(lotto);
      resultMap.put(condition, resultMap.getOrDefault(condition, 0) + 1);
    }
  }
  private WinningCondition checkLotto(Lotto lotto) {
    int matchCount = getMatchCount(lotto);

    for (WinningCondition condition : winningConditions) {
      if (condition.getMatchCount() == matchCount) {
        return condition;
      }
    }
    return null;
  }
  private boolean checkBonus(Lotto lotto) {
    List<Integer> numbers = lotto.getNumbers();
    if(numbers.contains(LottoInput.getBonus())) {
      return true;
    }
    return false;
  }


  private int getMatchCount(Lotto lotto) {
    List<Integer> numbers = lotto.getNumbers();
    int matchCount = 0;
    for (int winningNumbers : lotto.getNumbers()) {
      if (winningNumbers.contains(number)) {
        matchCount++;
      }
    }
    return matchCount;
    List<Lotto> lottos = lottoManager.getLottos();
    List<Integer> winningNumbers = lottoInput.getWinningNumbers();
    int matchCount = 0;
    for (winningNumbers : lotto.getNumbers()) {
      if (winningNumbers.)

    }
  }

  // 결과를 가져오는 메서드
  public Map<WinningCondition, Integer> getResult() {
    return resultMap;
  }



  // 수익률 계산 메소드
//  public double calculateProfitRate(int lottoCount) {
//    long totalSpent = lottoCount * 1_000; // 로또 단가는 1,000원입니다.
//    double totalProfitRate = (double) getTotalPrize() / totalSpent;
//    return totalProfitRate * 100; // %로 변환
//  }

//  public void printStatistics(int lottoCount) {
//    System.out.println("당첨 통계");
//    System.out.println("---");
//
////    System.out.printf("총 수익률은 %.2f%%입니다.\n", calculateProfitRate(lottoCount));
//  }


}
