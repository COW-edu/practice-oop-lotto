package lotto.message;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningRankMessage {
  FIFTH(3, false, "5,000"),
  FOURTH(4, false, "50,000"),
  THIRD(5, false, "1,500,000"),
  SECOND(5, true, "30,000,000"),
  FIRST(6, false, "2,000,000,000"),
  MISS(2, false, "0"),
  ;

  private final int winningCount;
  private final boolean hasBonus;
  private final String winningMoney;

  WinningRankMessage(int winningCount, boolean hasBonus, String winningMoney) {
    this.winningCount = winningCount;
    this.hasBonus = hasBonus;
    this.winningMoney = winningMoney;
  }

  public int getWinningCount() {
    return winningCount;
  }

  public boolean hasBonus() {
    return hasBonus;
  }

  public String getWinningMoney() {
    return winningMoney;
  }

  public static WinningRankMessage valueOf(int winningCount, boolean hasBonus) {

    if (checkSecondRank(winningCount, hasBonus)) {
      return SECOND;
    }
    return matchRank(winningCount);
  }

  private static boolean checkSecondRank(int winningCount, boolean hasBonus) {
    return (winningCount == SECOND.winningCount && hasBonus);
  }

  private static boolean checkSameCount(WinningRankMessage rank, int winningCount) {
    return rank.winningCount == winningCount;
  }

  private boolean isSecond() {
    return this == SECOND;
  }

  private static WinningRankMessage matchRank(int winningCount) {
    return Arrays.stream(values())
        .filter(Predicate.not(WinningRankMessage::isSecond))
        .filter(rank -> checkSameCount(rank, winningCount))
        .findFirst()
        .orElse(MISS);
  }
}
