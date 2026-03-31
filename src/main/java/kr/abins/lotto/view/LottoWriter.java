package kr.abins.lotto.view;

import java.util.Collections;
import java.util.List;

public interface LottoWriter {
    static void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
