package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.message.OutputMessage;
import lotto.message.WinningRankMessage;

import java.util.List;

public class OutputView {

  private static final int CHANGE_PERCENT = 100;
  private static final int CHANGE_PURCHASE_UNIT = 1000;
  private static final int INDEXING = 3;
  private static final int RANK_FIFTH = 3;
  private static final int RANK_SECOND = 5;
  private static final int RANK_FIRST = 6;
  private static final boolean HAS_BONUS = true;
  private static final boolean HAS_NOT_BONUS = false;

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
    List<Integer> winningLottoCountList = lottoController.countWinningNumber(purchasedLottoCounts);

    for (int winningCount = RANK_FIFTH; winningCount <= RANK_FIRST;
        winningCount++) {
      totalWinningMoney += calculateTotalWinningMoney(HAS_NOT_BONUS, winningLottoCountList,
          winningCount);
      if (winningCount == RANK_SECOND) {
        totalWinningMoney += calculateTotalWinningMoney(HAS_BONUS, winningLottoCountList,
            RANK_SECOND);
      }
    }
    return String.format("%.1f",
        totalWinningMoney / (purchasedLottoCounts * CHANGE_PURCHASE_UNIT) * CHANGE_PERCENT);
  }

  private double calculateTotalWinningMoney(boolean hasBonus, List<Integer> winningLottoCountList,
      int winningCount) {
    WinningRankMessage winningRankMessage = WinningRankMessage.valueOf(winningCount, hasBonus);
    System.out.println(
        outputResultComment(winningRankMessage, winningLottoCountList, winningCount));
    return lottoController.calculateTotalWinningMoney(winningRankMessage,
        winningLottoCountList, winningCount);
  }

  private String outputResultComment(WinningRankMessage winningRankMessage,
      List<Integer> winningLottoCountList,
      int winningCount) {
    String extraComment = "";
    if (winningRankMessage.hasBonus()) {
      extraComment = ", 보너스 볼 일치";
    }
    int winningIndex = winningCount - INDEXING;
    if (winningCount == RANK_FIRST) {
      winningIndex = RANK_FIRST_INDEX;
    }
    return String.format(OutputMessage.RESULT_LOTTO.getMessage(),
        winningRankMessage.getWinningCount(),
        extraComment, winningRankMessage.getWinningMoney(),
        winningLottoCountList.get(winningIndex));
  }
}
