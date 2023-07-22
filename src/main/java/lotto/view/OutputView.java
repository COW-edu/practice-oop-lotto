package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.message.WinningRankMessage;

import java.util.List;

public class OutputView {

  private static final int CHANGE_PERCENT = 100;
  private static final int CHANGE_PURCHASE_UNIT = 1000;
  private static final int INDEXING = 3;
  private static final int RANK_FIFTH = 3;
  private static final int RANK_SECOND = 5;
  private static final int RANK_FIRST = 6;
  private static final int RANK_FIRST_INDEX = 4;
  private static final boolean HAS_BONUS = true;
  private static final boolean HAS_NOT_BONUS = false;

  private final LottoController lottoController;

  public OutputView(LottoController lottoController) {
    this.lottoController = lottoController;
  }

  public void outputPurchaseAmount() {
    System.out.println("\"구입금액을 입력해 주세요.\"");
    System.out.println();
  }

  public void outputLottos(int purchasedLottoCounts) {
    System.out.println(
        String.format("\n%d개를 구매했습니다.", purchasedLottoCounts));
    lottoController.createLottoList(purchasedLottoCounts);
    List<Lotto> lottoList = lottoController.findLotto();
    StringBuilder totalStringLottos = new StringBuilder();

    for (int index = 0; index < purchasedLottoCounts; index++) {
      totalStringLottos.append(lottoList.get(index).getNumbers()).append("\n");
    }
    System.out.println(totalStringLottos.toString());
  }

  public void outputWinningNumbers() {
    System.out.println("\n당첨 번호를 입력해 주세요.");
  }

  public void outputBonusNumber() {
    System.out.println("\n보너스 번호를 입력해 주세요.");
  }

  public void outputRateOfLotteryWinnings(String totalWinningMoney) {
    System.out.println(
        String.format("총 수익률은 %s%%입니다.", totalWinningMoney));
  }

  public String outputLottoTotalResult(int purchasedLottoCounts) {
    double totalWinningMoney = 0.0;
    System.out.println("\n당첨 통계\n---");
    List<Integer> winningLottoCountList = lottoController.countWinningNumber(purchasedLottoCounts);

    totalWinningMoney = getTotalWinningMoney(totalWinningMoney, winningLottoCountList);
    return String.format("%.1f",
        totalWinningMoney / (purchasedLottoCounts * CHANGE_PURCHASE_UNIT) * CHANGE_PERCENT);
  }

  private double getTotalWinningMoney(double totalWinningMoney,
      List<Integer> winningLottoCountList) {
    for (int winningCount = RANK_FIFTH; winningCount <= RANK_FIRST;
        winningCount++) {
      totalWinningMoney += calculateTotalWinningMoney(HAS_NOT_BONUS, winningLottoCountList,
          winningCount);

      if (winningCount == RANK_SECOND) {
        totalWinningMoney += calculateTotalWinningMoney(HAS_BONUS, winningLottoCountList,
            RANK_SECOND);
      }
    }
    return totalWinningMoney;
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
    return String.format("%d개 일치%s (%s원) - %d개",
        winningRankMessage.getWinningCount(),
        extraComment, winningRankMessage.getWinningMoney(),
        winningLottoCountList.get(winningIndex));
  }
}
