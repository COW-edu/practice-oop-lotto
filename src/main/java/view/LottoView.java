package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import constant.LottoInformation;
import constant.LottoMessage;
import lotto.Lotto;

import java.util.List;

// 목적 : 출력과 입력과 검증
public class LottoView {

    public int inputPurchaseAmount() {
        System.out.println(LottoMessage.INPUT_PURCHASE_AMOUNT);
        int price = Integer.parseInt(Console.readLine());
        validatePurchaseAmount(price);
        return price;
    }

    public void printPurchaseMessage(int numberOfLotto) {
        System.out.println(numberOfLotto + LottoMessage.PURCHASED_NUMBER_OF_LOTTO);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT_ERROR);
        }
        if (purchaseAmount % LottoInformation.PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLES_PURCHASE_AMOUNT_ERROR);
        }
    }

    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }
}
