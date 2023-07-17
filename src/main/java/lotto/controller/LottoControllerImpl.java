package lotto.controller;

import lotto.domain.Lotto;
import lotto.message.ResultMessage;
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
  public List<Lotto> findLottoList() {
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
  public int[] countWinningNumber(int purchasedLottoCounts) {
    return lottoService.countingWinningNumber(purchasedLottoCounts);
  }

  @Override
  public double calculateTotalWinningMoney(ResultMessage resultMessage, int[] winningLottoCountList,
      int correctNumberCount) {
    int winningMoney = 0;
    winningMoney += Integer.parseInt(resultMessage.getWinningMoney().replaceAll(",", ""))
        * winningLottoCountList[correctNumberCount - 3];
    return winningMoney;
  }
}
