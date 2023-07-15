package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.message.InputMessage;
import lotto.message.LottoExceptionMessage;

public class InputView {

  private final LottoController lottoController;
  private static final int UNIT = 1000;

  public InputView(LottoController lottoController) {
    this.lottoController = lottoController;
  }

  public int inputPurchaseAmount() throws IllegalArgumentException {
    System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    int purchaseAmount = validatePurchaseAmount(Console.readLine());
    int purchasedLottoCounts = lottoController.checkPurchasedLottoCounts(purchaseAmount);
    System.out.println();
    return purchasedLottoCounts;
  }

  private int validatePurchaseAmount(String inputMoney) {
    int money = validateInteger(inputMoney);
    validateDivided(money);
    validateMinimum(money);
    return money;
  }

  private int validateInteger(String inputMoney) {
    try {
      return Integer.parseInt(inputMoney);
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

  public void inputWinningNumbers() throws IllegalArgumentException {
    System.out.println(InputMessage.INPUT_WIN_LOTTO_NUMBERS.getMessage());
    String winningNumbers = Console.readLine();
    lottoController.insertWinningLottoNumbers(winningNumbers);
  }

  public void inputBonusNumber() throws IllegalArgumentException {
    System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
    int bonusNumber = Integer.parseInt(Console.readLine());
    lottoController.insertBonusNumber(bonusNumber);
  }
}
