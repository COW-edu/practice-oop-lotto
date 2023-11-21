package lotto.controller;

import lotto.config.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;


public class LottoPurchaseController implements Controller {
    private static final int PURCHASE_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoPurchaseController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void service(Map<String, Object> model) {
        int purchaseMoney = inputView.inputPurchaseMoney();
        int purchaseAmount = calculatePurchaseAmount(purchaseMoney);

        model.put("Purchase", purchaseAmount);

        outputView.outputLottoAmount(purchaseAmount);
    }

    public int calculatePurchaseAmount(int purchaseMoney) {
        validatePurchase(purchaseMoney);
        return purchaseMoney / PURCHASE_PRICE;
    }

    private void validatePurchase(int purchaseMoney) {
        validatePurchaseAmount(purchaseMoney);
        validatePurchaseMinimumMoney(purchaseMoney);
    }

    private void validatePurchaseAmount(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_MONEY_NO_DIVISION.getErrorMessage());
        }
    }

    private void validatePurchaseMinimumMoney(int purchaseMoney) {
        if (purchaseMoney < PURCHASE_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_MONEY_MINIMUMBER_MONEY.getErrorMessage());
        }
    }


}
