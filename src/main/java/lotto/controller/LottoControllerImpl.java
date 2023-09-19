package lotto.controller;

import lotto.domain.Lotto;
import lotto.message.WinningRankMessage;
import lotto.service.LottoService;

import java.util.List;

public class LottoControllerImpl implements LottoController {

  private final LottoService lottoService;

  public LottoControllerImpl(LottoService lottoService) {
    this.lottoService = lottoService;
  }

  @Override
  public int checkPurchasedLottoCounts(int purchaseAmount) throws IllegalArgumentException {
    return lottoService.calculatePurchaseAmount(purchaseAmount);
  }

  @Override
  public void createLottoList(int purchasedLottoCounts) {
    lottoService.createRandomLottoNumbers(purchasedLottoCounts);
  }

  @Override
  public List<Lotto> findLotto() {
    return lottoService.findRandomLottoNumbers();
  }

  @Override
  public void insertWinningLottoNumbers(String winningNumbers)
      throws IllegalArgumentException {
    lottoService.saveWinningLottoNumbers(winningNumbers);
  }

  @Override
  public void insertBonusNumber(int bonusNumber) throws IllegalArgumentException {
    lottoService.saveBonusNumber(bonusNumber);
  }

  @Override
  public List<Integer> countWinningNumber(int purchasedLottoCounts) {
    return lottoService.countWinningNumber(purchasedLottoCounts);
  }

  @Override
  public double calculateTotalWinningMoney(WinningRankMessage winningRankMessage,
      List<Integer> winningLottoCountList,
      int winningCount) {
    return lottoService.calculateTotalWinningMoney(winningRankMessage,
        winningLottoCountList, winningCount);
  }
}
