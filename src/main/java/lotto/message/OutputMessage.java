package lotto.message;

public enum OutputMessage {
  LOTTO_RESULT("%d개 일치%s (%s원) - %d개"),
  RATE_OF_LOTTERY_WINNINGS("총 수익률은 %s%%입니다."),
  ;

  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
