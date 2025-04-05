package lotto;

import java.util.List;

public class LottoView {
    public void printLottoDigit(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printPurchasedCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }
}
