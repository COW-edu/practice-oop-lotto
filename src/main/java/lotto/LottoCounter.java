package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoCounter {
    private int lottoCount;
    private final LottoView view;

    public LottoCounter(LottoView view) {
        this.view = view;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine().trim();
            int money = Integer.parseInt(input);
            lottoCount = money / 1000;
            printLottoDigit();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private void printLottoDigit() {
        System.out.println();
        view.printPurchasedCount(lottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
