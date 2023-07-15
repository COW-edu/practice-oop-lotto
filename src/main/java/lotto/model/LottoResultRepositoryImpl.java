package lotto.model;

public class LottoResultRepositoryImpl implements LottoResultRepository {

  private static final int RANK_1 = 3;
  private static final int INDEXING = 3;
  private final int[] lottoResult = new int[5];

  @Override
  public void saveLottoResult(int winningCount) {
    boolean isWinning = (winningCount >= RANK_1);
    int lottoResultIndex = winningCount - INDEXING;
    if (isWinning) {
      lottoResult[lottoResultIndex] += 1;
    }
  }

  @Override
  public int[] findLottoResult() {
    return lottoResult;
  }
}
