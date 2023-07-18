package lotto.model;

import java.util.List;

public interface LottoResultRepository {

  void saveResult(int winningCount, boolean isBonus);

  List<Integer> findList();
}
