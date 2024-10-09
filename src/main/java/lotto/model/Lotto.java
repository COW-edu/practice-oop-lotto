package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ErrorMessage;
import lotto.view.OutputView;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers; //로또 갯수 저장필드
    private static final int LOOTO_AMOUNT = 1000;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 1;
    private static final int COUNT = 1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LOOTO_AMOUNT) {
            OutputView.printErrorMessage(ErrorMessage.ERROR_MINIMUM_PURCHASE_AMOUNT);
            throw new IllegalArgumentException();
        }
        if (amount % LOOTO_AMOUNT != 0) {
            OutputView.printErrorMessage(ErrorMessage.ERROR_INVALID_PURCHASE_AMOUNT);
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            OutputView.printErrorMessage(ErrorMessage.ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                OutputView.printErrorMessage(ErrorMessage.ERROR_INVALID_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }
}
