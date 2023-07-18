package lotto.model;

import java.util.List;

public interface LottoResultRepository {

  void saveLottoResult(int winningCount);

  List<Integer> findList();
}
