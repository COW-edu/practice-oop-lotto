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
    return winningLotto.getBonusNumber();
  }

  @Override
  public void saveBonusNumber(int bonusNumber) {
    winningLotto.setBonusNumber(bonusNumber);
  }

  @Override
  public void saveNumber(String winningNumbers) {
    winningLotto.saveWinningNumber(winningNumbers);
  }

  @Override
  public List<Integer> findWinningLotto() {
    return winningLotto.getWinningNumber();
  }
}
