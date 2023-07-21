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

  public void inputWinningNumbers() throws IllegalArgumentException {
    String winningNumbers = Console.readLine();
    lottoController.insertWinningLottoNumbers(winningNumbers);
  }

  public void inputBonusNumber() throws IllegalArgumentException {
    int bonusNumber = validateInteger(Console.readLine());
    lottoController.insertBonusNumber(bonusNumber);
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

    if (isNotDividedLottoPrice(money)) {
      throw new IllegalArgumentException(LottoExceptionMessage.NOT_DIVIDED_UNIT.getMessage());
    }
  }

  private boolean isNotDividedLottoPrice(int money) {
    return money % UNIT != 0;
  }

  private void validateMinimum(int money) {

    if (isUnderUnit(money)) {
      throw new IllegalArgumentException(LottoExceptionMessage.LESS_THAN_MINIMUM.getMessage());
    }
  }

  private boolean isUnderUnit(int money) {
    return money < UNIT;
  }
}
