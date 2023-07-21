package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultRepositoryImpl implements LottoResultRepository {

  private static final int RANK_FIFTH_COUNT = 3;
  private static final int RANK_SECOND_COUNT = 5;
  private static final int RANK_SECOND_INDEX = 3;
  private static final int INDEXING = 3;
  private final List<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

  @Override
  public void saveLottoResult(int winningCount, boolean isBonus) {
    int lottoResultIndex = winningCount - INDEXING;

    if (isNotWinning(winningCount)) {
      return;
    }
    if (isBonusRank(winningCount, isBonus)) {
      lottoResult.set(RANK_SECOND_INDEX, lottoResult.get(RANK_SECOND_INDEX) + 1);
      return;
    }
    lottoResult.set(lottoResultIndex, lottoResult.get(lottoResultIndex) + 1);
  }

  @Override
  public List<Integer> findLottoResults() {
    return lottoResult;
  }

  private boolean isBonusRank(int winningCount, boolean isBonus) {
    return isBonus && (winningCount == RANK_SECOND_COUNT);
  }

  private boolean isNotWinning(int winningCount) {
    return winningCount < RANK_FIFTH_COUNT;
  }
}
