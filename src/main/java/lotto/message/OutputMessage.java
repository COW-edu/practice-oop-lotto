package lotto.message;

public enum OutputMessage {
  INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
  PURCHASED_LOTTO_COUNTS("\n%d개를 구매했습니다."),
  INPUT_WIN_LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
  RESULT_LOTTO("%d개 일치%s (%s원) - %d개"),
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
