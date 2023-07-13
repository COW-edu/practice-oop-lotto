package lotto.model;

public class LottoResultRepositoryImpl implements LottoResultRepository {

  private final int MIN_LOTTERY_WINNING_COUNT = 3;
  private final int CHANGE_WINNING_COUNT_TO_INDEX = 3;
  private final int[] lottoResult = new int[5];

  @Override
  public void saveLottoResult(int winningCount) {
    boolean isWinning = (winningCount >= MIN_LOTTERY_WINNING_COUNT);
    int lottoResultIndex = winningCount - CHANGE_WINNING_COUNT_TO_INDEX;
    if (isWinning) {
      lottoResult[lottoResultIndex] += 1;
    }
  }

  @Override
  public int[] findLottoResult() {
    return lottoResult;
  }
}
