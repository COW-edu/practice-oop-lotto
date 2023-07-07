package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;
import lotto.message.LottoExceptionMessage;
import lotto.controller.LottoController;

import java.util.List;

public class InputView {

    private final LottoController lottoController = new LottoController();

    private int isCorrectPurchaseAmount(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_CORRECT_PURCHASE_AMOUNT.getMessage());
        }
    }
    public int inputPurchaseAmount(InputMessage message) throws IllegalArgumentException {
        System.out.println(message.getMessage());
        int purchaseAmount = isCorrectPurchaseAmount(Console.readLine());
        int purchasedLottoCounts = lottoController.checkPurchasedLottoCounts(purchaseAmount);
        System.out.println();
        return purchasedLottoCounts;
    }

    public List<Integer> inputWinningNumbers(InputMessage message) throws IllegalArgumentException {
        System.out.println(message.getMessage());
        String winningNumbers = Console.readLine();
        return lottoController.insertWinningLottoNumbers(winningNumbers);
    }

    public List<Integer> inputBonusNumber(InputMessage message) throws IllegalArgumentException {
        System.out.println(message.getMessage());
        int bonusNumber = Integer.parseInt(Console.readLine());
        return lottoController.insertBonusNumber(bonusNumber);
    }
}
