package model.win;

import java.util.Map;

public class WinLottoResult {
  private final Map<String, Integer> winCountResult;

  public WinLottoResult(Map<String, Integer> winCountResult) {
    this.winCountResult = winCountResult;
  }

  public int getValue(String winCount) {
    return winCountResult.get(winCount);
  }
}
