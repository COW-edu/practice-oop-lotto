package lotto.view;

import lotto.model.Lotto;
import lotto.view.ViewText;

public class OutputView {

  public void printPurchaseAmountMessage(int purchaseAmount) {
    System.out.println(ViewText.INPUT_PURCHASE_PRICE.getData());
    System.out.print(purchaseAmount);
    System.out.println(ViewText.OUTPUT_PURCHASE_AMOUNT.getData());
  }

  public void printLotto(Lotto lotto) {
    System.out.println(lotto.getNumbers().toString());
  }

  public void printReadWinNumbersMessage() {
    System.out.println(ViewText.INPUT_WIN_NUMBER.getData());
  }

  public void printReadBonusNumbersMessage() {
    System.out.println(ViewText.INPUT_BONUS_NUMBER.getData());
  }
}
