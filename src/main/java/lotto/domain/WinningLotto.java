package lotto.domain;

import java.util.List;

public interface WinningLotto {

  void saveWinningNumber(String initialWinningNumber);

  void setBonusNumber(int bonusNumber);

  int getBonusNumber();

  int calculateWinningCount(List<Integer> lottoList);
}
