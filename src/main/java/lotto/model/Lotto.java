package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers; //로또 갯수 저장필드
    private static final int LOOTO_AMOUNT = 1000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LOOTO_AMOUNT) {
            OutputView.printMinimumPurchaseMessage();
            throw new IllegalArgumentException();
        }
        if (amount % LOOTO_AMOUNT != 0) {
            OutputView.printInvalidPurchaseMessage();
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                OutputView.printErrorMessageInvalidNumber();
                throw new IllegalArgumentException();
            }
        }
    }
}
