package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.message.InputMessage;
import lotto.message.OutputMessage;
import lotto.message.ResultMessage;

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

  public void outPutLottoList(int purchasedLottoCounts) {
    System.out.println(
        String.format(InputMessage.PURCHASED_LOTTO_COUNTS.getMessage(), purchasedLottoCounts));
    lottoController.createLottoList(purchasedLottoCounts);
    List<Lotto> lottoList = lottoController.findLottoList();
        StringBuilder totalStringLottoList = new StringBuilder();
    for (int index = 0; index < purchasedLottoCounts; index++) {
      totalStringLottoList.append(lottoList.get(index).getNumbers()).append("\n");
    }
    System.out.println(totalStringLottoList.toString());
  }

  public String outPutLottoTotalResult(int purchasedLottoCounts) {
    ResultMessage resultMessage;
    double totalWinningMoney = 0.0;
    System.out.println("\n당첨 통계\n---");
    int[] winningLottoCountList = lottoController.countWinningNumber(purchasedLottoCounts);
    for (int correctNumberCount = RESULT_INDEX_THREE; correctNumberCount <= RESULT_INDEX_SEVEN;
        correctNumberCount++) {
      resultMessage = ResultMessage.valueOf(correctNumberCount);
      System.out.println(
          outPutResultComment(resultMessage, winningLottoCountList, correctNumberCount));
      totalWinningMoney += lottoController.calculateTotalWinningMoney(resultMessage,
          winningLottoCountList, correctNumberCount);
    }
    return String.format("%.1f",
        totalWinningMoney / (purchasedLottoCounts * CHANGE_PURCHASE_MONEY) * CHANGE_PERCENT);
  }

  private String outPutResultComment(ResultMessage resultMessage, int[] winningLottoCountList,
      int correctNumberCount) {
    return String.format(OutputMessage.LOTTO_RESULT.getMessage(), resultMessage.getWinningCount(),
        resultMessage.getBonusComment(), resultMessage.getWinningMoney(),
        winningLottoCountList[correctNumberCount - 3]);
  }

  public void outPutRateOfLotteryWinnings(String totalWinningMoney) {
    System.out.println(
        String.format(OutputMessage.RATE_OF_LOTTERY_WINNINGS.getMessage(), totalWinningMoney));
  }
}
