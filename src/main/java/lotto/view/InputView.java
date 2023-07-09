package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.message.InputMessage;
import lotto.message.LottoExceptionMessage;

import java.util.List;

public class InputView {

    private final LottoController lottoController;

    public InputView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public int inputPurchaseAmount() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        int purchaseAmount = isCorrectPurchaseAmount(Console.readLine());
        int purchasedLottoCounts = lottoController.checkPurchasedLottoCounts(purchaseAmount);
        System.out.println();
        return purchasedLottoCounts;
    }
    private int isCorrectPurchaseAmount(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_CORRECT_PURCHASE_AMOUNT.getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_WIN_LOTTO_NUMBERS.getMessage());
        String winningNumbers = Console.readLine();
        return lottoController.insertWinningLottoNumbers(winningNumbers);
    }

    public void inputBonusNumber() throws IllegalArgumentException {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = Integer.parseInt(Console.readLine());
        lottoController.insertBonusNumber(bonusNumber);
    }
}
