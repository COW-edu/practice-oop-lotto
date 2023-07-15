package lotto.model;

import java.util.List;
import lotto.domain.WinningLotto;

public class WinningLottoNumberRepositoryImpl implements WinningLottoNumberRepository {

  private final WinningLotto winningLotto;

  public WinningLottoNumberRepositoryImpl(WinningLotto winningLotto) {
    this.winningLotto = winningLotto;
  }

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
