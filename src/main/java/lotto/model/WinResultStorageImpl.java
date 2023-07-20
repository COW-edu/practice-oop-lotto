package lotto.model;

import java.util.List;

public class WinResultStorageImpl implements WinResultStorage {

  private static final int THREE_ACCORD_INDEX = 0;
  private static final int FOUR_ACCORD_INDEX = 1;
  private static final int FIVE_ACCORD_INDEX = 2;
  private static final int SIX_ACCORD_INDEX = 3;
  private static final int BONUS_ACCORD_INDEX = 4;
  private static final int GAP_VALUE_BETWEEN_ACCORD_INDEX = 3;

  private final int[] winResult = {0, 0, 0, 0, 0};
  private double profitRate;

  public WinResultStorageImpl(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
    calculateWinResult(lottoList, winNumbers, bonusNumber);
    calculateProfitRate();
  }

  @Override
  public int[] getWinResult() {
    return winResult;
  }

  @Override
  public double getProfitRate() {
    return profitRate;
  }

  private void calculateWinResult(List<Lotto> lottoList, List<Integer> winNumbers,
      int bonusNumber) {
    for (Lotto lotto : lottoList) {
      List<Integer> numbers = lotto.getNumbers();

      int accordWinNumber = 0;
      int accordBonusNumber = 0;

      for (Integer number : numbers) {
        if (winNumbers.contains(number)) {
          accordWinNumber += 1;
        }
        if (number == bonusNumber) {
          accordBonusNumber += 1;
        }
      }

      if (accordWinNumber >= 3) {
        if (accordWinNumber == 5 && accordBonusNumber == 1) {
          winResult[BONUS_ACCORD_INDEX] += 1;
        } else {
          winResult[accordWinNumber - GAP_VALUE_BETWEEN_ACCORD_INDEX] += 1;
        }
      }
    }
  }

  private void calculateProfitRate() {
    int profit = winResult[THREE_ACCORD_INDEX] * WinRewardData.THREE_ACCORD_REWARD.getData()
        + winResult[FOUR_ACCORD_INDEX] * WinRewardData.FOUR_ACCORD_REWARD.getData()
        + winResult[FIVE_ACCORD_INDEX] * WinRewardData.FIVE_ACCORD_REWARD.getData()
        + winResult[SIX_ACCORD_INDEX] * WinRewardData.SIX_ACCORD_REWARD.getData()
        + winResult[BONUS_ACCORD_INDEX] * WinRewardData.BONUS_ACCORD_REWARD.getData();
    profitRate = (double) profit / 1000;
  }
}
