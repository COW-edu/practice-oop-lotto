package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Constants;
import lotto.model.Lotto;

public class AmountInput {
    private final int amount;

    public AmountInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            amount = Integer.parseInt(Console.readLine().trim());
            Lotto.checkAmount(amount);
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_AMOUNT);
        }
    }

    public int getAmount() {
        return amount;
    }
}