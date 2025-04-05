package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberCreater {
    private final List<List<Integer>> lottoNumbers;
    private final LottoView view;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_STEP_NUMBER = 6;



    public LottoNumberCreater(LottoView view) {
        this.lottoNumbers = new ArrayList<>();
        this.view = view;
    }

    public void numberCreate(int lottoDigit) {
        for (int i = 0; i < lottoDigit; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_STEP_NUMBER);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            view.printLottoDigit(numbers);
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> lotto : lottoNumbers) {
            copy.add(new ArrayList<>(lotto));
        }
        return copy;
    }
}
