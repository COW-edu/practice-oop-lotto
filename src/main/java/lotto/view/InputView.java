package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.message.LottoExceptionMessage;

public class InputView {

  private static final int UNIT = 1000;

  private final LottoController lottoController;

  public InputView(LottoController lottoController) {
    this.lottoController = lottoController;
  }

  public int inputPurchaseAmount() throws IllegalArgumentException {
    int purchaseAmount = validatePurchaseAmount(Console.readLine());
    return lottoController.checkPurchasedLottoCounts(purchaseAmount);
  }

  private int validatePurchaseAmount(String inputMoney) {
    int money = validateInteger(inputMoney);
    validateDivided(money);
    validateMinimum(money);
    return money;
  }

  private int validateInteger(String inputValue) {
    try {
      return Integer.parseInt(inputValue);
    } catch (Exception e) {
      throw new IllegalArgumentException(
          LottoExceptionMessage.NOT_INTEGER.getMessage());
    }
  }

  private void validateDivided(int money) {
    boolean isNotDivided1000 = (money % UNIT != 0);
    if (isNotDivided1000) {
      throw new IllegalArgumentException(LottoExceptionMessage.NOT_DIVIDED_UNIT.getMessage());
    }
  }

  private void validateMinimum(int money) {
    boolean isUnderUnit = (money < UNIT);
    if (isUnderUnit) {
      throw new IllegalArgumentException(LottoExceptionMessage.LESS_THAN_MINIMUM.getMessage());
    }
  }
}
