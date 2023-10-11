package lotto.Entity;

import static lotto.Constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.List;

public class Lotto {
    // Lotto 구현
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoRow) {
        validate(lottoRow);
        this.numbers = lottoRow;
    }

    public int getLottoRowSize() {
        return LOTTO_ROW_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_ROW_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}
