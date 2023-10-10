package lotto;

public enum WinningCondition {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),  // 보너스 번호 일치
  THIRD(5, 1_500_000),   // 보너스 번호 불일치
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NONE(0, 0);

  private final int matchCount;  // 일치해야 하는 숫자의 개수
  private final int prize;  // 해당 등수의 상금
  private boolean isBonus; // 보너스 번호 일치 여부

  WinningCondition(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrize() {
    return prize;
  }

}

