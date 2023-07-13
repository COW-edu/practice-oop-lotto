package lotto.model;

public interface LottoResultRepository {

  void saveLottoResult(int winningCount);

  int[] findLottoResult();
}
