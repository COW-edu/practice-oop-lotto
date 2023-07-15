package lotto.domain;

import java.util.List;

public interface WinningLotto {

  void saveWinningNumber(String initialWinningNumber);
  void setBonusNumber(int bonusNumber);
  List<Integer> getWinningNumber();
  int getBonusNumber();
}
