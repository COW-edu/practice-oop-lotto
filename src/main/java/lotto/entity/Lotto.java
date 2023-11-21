package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto extends LottoException {

    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoRow) {
        rowSizeOfViolation(lottoRow);
        duplicateNumberCheck(lottoRow);
        this.numbers = new ArrayList<>(lottoRow);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    
}
