package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoRun implements Runnable {

  private final InputView inputView;
  private final OutputView outputView;

  public LottoRun(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  @Override
  public void run() {
    try {
      outputView.outputPurchaseAmount();
      int purchasedLottoCounts = inputView.inputPurchaseAmount();
      outputView.outputLottos(purchasedLottoCounts);
      outputView.outputWinningNumbers();
      inputView.inputWinningNumbers();
      inputView.inputBonusNumber();
      outputView.outputBonusNumber();

      String totalWinningMoney = outputView.outputLottoTotalResult(purchasedLottoCounts);
      outputView.outputRateOfLotteryWinnings(totalWinningMoney);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
