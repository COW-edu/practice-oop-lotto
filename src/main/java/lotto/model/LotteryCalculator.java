package lotto.model;

import lotto.Lotto;
import lotto.validation.LotteryNumberValidator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LotteryCalculator {
    private static final int LOTTO_PRICE = 1000;
    public static int divideByLottoPrice(String amount) {
        LotteryNumberValidator.validateNumberFormat(amount);
        int newAmount = Integer.parseInt(amount);
        LotteryNumberValidator.validatePurchaseAmountDivisibility(newAmount);
        return newAmount / LOTTO_PRICE;
    }
    public static int[] calculateResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[5];
        for (Lotto lotto : lottoTickets) {
            int count = matchAndCountWinningNumbers(lotto, winningNumbers);
            switch (count) {
                case 3:
                    result[0]++;
                    break;
                case 4:
                    result[1]++;
                    break;
                case 5:
                    match5Numbers(result, lotto, bonusNumber);
                    break;
                case 6:
                    result[4]++;
                    break;
            }
        }
        return result;
    }
    private static void match5Numbers(int[] result, Lotto lotto, int bonusNumber) {
        if (matchBonusNumber(lotto, bonusNumber)) {
            result[3]++;
            return;
        }
        result[2]++;
    }
    public static int matchAndCountWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int)lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
    public static boolean matchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
