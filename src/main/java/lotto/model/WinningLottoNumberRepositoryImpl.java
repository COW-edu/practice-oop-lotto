package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumberRepositoryImpl implements WinningLottoNumberRepository {

  private static List<Integer> winningLottoNumbersList = new ArrayList<>();
  private int bonusNumber;

  @Override
  public int getBonusNumber() {
    return bonusNumber;
  }

  @Override
  public void saveBonusNumber(int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  @Override
  public void saveWinningLottoNumbers(List<Integer> winningNumbers) {
    winningLottoNumbersList = winningNumbers;
  }

  @Override
  public List<Integer> findWinningLottoNumbersList() {
    return winningLottoNumbersList;
  }
}
