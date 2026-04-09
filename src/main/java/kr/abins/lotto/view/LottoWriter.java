package kr.abins.lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWriter {

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(final List<Integer> numbers) {
        final List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        System.out.println(sorted);
    }

    public void printWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
