package lotto;

import lotto.message.InputMessage;
import lotto.view.InputView;
import lotto.message.LottoExceptionMessage;
import lotto.message.OutputMessage;
import lotto.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        isNotEnoughSize(numbers);
        isDuplicate(numbers);
        isInOneToFortyFive(numbers);
    }
    private void isNotEnoughSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.IS_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
        }
    }
    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoExceptionMessage.IS_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
    private void isInOneToFortyFive(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_IN_1_45.getMessage());
            }
        }
    }
    public static void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        try {
            int purchasedLottoCounts = inputView.inputPurchaseAmount(InputMessage.INPUT_PURCHASE_AMOUNT);
            outputView.outPutLottoList(purchasedLottoCounts, InputMessage.PURCHASED_LOTTO_COUNTS);
            List<Integer> winningNumbers = inputView.inputWinningNumbers(InputMessage.INPUT_WIN_LOTTO_NUMBERS);
            Lotto lotto = new Lotto(winningNumbers);
            lotto.numbers = inputView.inputBonusNumber(InputMessage.INPUT_BONUS_NUMBER);
            lotto.isDuplicate(lotto.numbers);
            String totalWinningMoney = outputView.outPutLottoTotalResult(OutputMessage.LOTTO_RESULT, purchasedLottoCounts);
            outputView.rateOfLotteryWinnings(OutputMessage.RATE_OF_LOTTERY_WINNINGS, totalWinningMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
