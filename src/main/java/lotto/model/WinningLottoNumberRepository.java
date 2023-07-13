package lotto.model;

import java.util.List;

public interface WinningLottoNumberRepository {

  int getBonusNumber();

  List<Integer> saveWinningLottoNumbers(List<Integer> winningNumbers);

  void saveBonusNumber(int bonusNumber);

  List<Integer> findWinningLottoNumbersList();
}
