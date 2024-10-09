package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

// 목적 : 출력과 입력과 검증
public class LottoView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        validatePurchaseAmount(price);
        return price;
    }

    public void printPurchaseMessage(int numberOfLotto) {
        String purchasedNumberOfLotto = numberOfLotto + "개를 구매했습니다.";
        System.out.println(purchasedNumberOfLotto);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.negativePurchaseAmountError);
        }
        if (purchaseAmount % LottoInformation.PRICE_PER_LOTTO != 0) {
            String multiplesPurchaseAmountError = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
            throw new IllegalArgumentException(multiplesPurchaseAmountError);
        }
    }

    public void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

}
