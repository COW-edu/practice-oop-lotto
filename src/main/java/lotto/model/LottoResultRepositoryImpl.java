package lotto.model;

public class LottoResultRepositoryImpl implements LottoResultRepository {

  private static final int RANK_1 = 3;
  private static final int INDEXING = 3;
  private final List<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

  @Override
  public void saveLottoResult(int winningCount) {
    boolean isWinning = (winningCount >= RANK_1);
    int lottoResultIndex = winningCount - INDEXING;
    if (isWinning) {
      lottoResult[lottoResultIndex] += 1;
    }
    if (isBonusRank) {
      lottoResult.set(RANK_SECOND_INDEX, lottoResult.get(RANK_SECOND_INDEX) + 1);
      return;
    }
    lottoResult.set(lottoResultIndex, lottoResult.get(lottoResultIndex) + 1);
  }

  @Override
  public List<Integer> findList() {
    return lottoResult;
  }
}
