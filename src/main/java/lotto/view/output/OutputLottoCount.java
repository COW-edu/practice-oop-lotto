package lotto.view.output;

import lotto.domain.Money;

public class OutputLottoCount {

    private final static String PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void printLottoCount(Money money){
        System.out.println(money.getMoney() / Output.LOTTO_PRICE + PURCHASE_LOTTO);
    }
}
