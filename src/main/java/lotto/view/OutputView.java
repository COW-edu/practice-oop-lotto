package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.message.OutputMessage;
import lotto.message.WinningRankMessage;

import java.util.List;

public class OutputView {

  private static final int CHANGE_PERCENT = 100;
  private static final int CHANGE_PURCHASE_MONEY = 1000;
  private static final int RESULT_INDEX_THREE = 3;
  private static final int RESULT_INDEX_SEVEN = 7;

  private final LottoController lottoController;

  public OutputView(LottoController lottoController) {
    this.lottoController = lottoController;
  }

  public void outputPurchaseAmount() {
    System.out.println(OutputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    System.out.println();
  }

  public void outPutLottoList(int purchasedLottoCounts) {
    System.out.println(
        String.format(OutputMessage.PURCHASED_LOTTO_COUNTS.getMessage(), purchasedLottoCounts));
    lottoController.createLottoList(purchasedLottoCounts);
    List<Lotto> lottoList = lottoController.findLottoList();
    StringBuilder totalStringLottoList = new StringBuilder();
    for (int index = 0; index < purchasedLottoCounts; index++) {
      totalStringLottoList.append(lottoList.get(index).getNumbers()).append("\n");
    }
    System.out.println(totalStringLottoList.toString());
  }

  public void outputWinningNumbers() {
    System.out.println(OutputMessage.INPUT_WIN_LOTTO_NUMBERS.getMessage());
  }

  public void outputBonusNumber() {
    System.out.println(OutputMessage.INPUT_BONUS_NUMBER.getMessage());
  }

  public void outPutRateOfLotteryWinnings(String totalWinningMoney) {
    System.out.println(
        String.format(OutputMessage.RATE_OF_LOTTERY_WINNINGS.getMessage(), totalWinningMoney));
  }

  public String outPutLottoTotalResult(int purchasedLottoCounts) {
    double totalWinningMoney = 0.0;
    System.out.println("\n당첨 통계\n---");
    int[] winningLottoCountList = lottoController.countWinningNumber(purchasedLottoCounts);

    for (int winningCount = RANK_FIFTH; winningCount <= RANK_FIRST;
        winningCount++) {
      if (winningCount == RANK_FIRST) {
        totalWinningMoney += calculateTotalWinningMoney(HAS_BONUS, winningLottoCountList, RANK_SECOND);
      }
      totalWinningMoney += calculateTotalWinningMoney(HAS_NOT_BONUS, winningLottoCountList, winningCount);
    }
    return String.format("%.1f",
        totalWinningMoney / (purchasedLottoCounts * CHANGE_PURCHASE_UNIT) * CHANGE_PERCENT);
  }

  private String outputResultComment(WinningRankMessage winningRankMessage,
      int[] winningLottoCountList,
      int winningCount) {
    String extraComment = "";
    if (winningRankMessage.hasBonus()) {
      extraComment = ", 보너스 볼 일치";
    }
    return String.format(OutputMessage.LOTTO_RESULT.getMessage(),
        winningRankMessage.getWinningCount(),
        extraComment, winningRankMessage.getWinningMoney(),
        winningLottoCountList[winningCount - INDEXING]);
  }

  private double calculateTotalWinningMoney(boolean hasBonus, int[] winningLottoCountList, int winningCount) {
    WinningRankMessage winningRankMessage;
    winningRankMessage = WinningRankMessage.valueOf(winningCount, hasBonus);
    System.out.println(
        outputResultComment(winningRankMessage, winningLottoCountList, winningCount));
    return lottoController.calculateTotalWinningMoney(winningRankMessage,
        winningLottoCountList, winningCount);
  }
}
