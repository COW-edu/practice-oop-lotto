package lotto.view;

import lotto.domain.Money;

public class OutputLottoCount {

    public static void printLottoCount(Money money){
        System.out.println(money.getMoney() / Output.LOTTO_PRICE + "개를 구매했습니다.");
    }
}
