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

    static void printLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    static void printWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
    static void printNewLine() {
        System.out.println();
    }
}
