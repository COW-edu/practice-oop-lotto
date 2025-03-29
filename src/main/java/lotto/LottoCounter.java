package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoCounter {
    private int lottoCount;

    public LottoCounter() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine().trim();
            int money = Integer.parseInt(input);
            lottoCount = money / 1000;
            printLottoDigit();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 된 금액을 입력해주세요.");
        }
    }

    private void printLottoDigit() {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
