package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberCreater {
    private List<List<Integer>> lottoNumbers;

    public LottoNumberCreater() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void numberCreate(int lottoDigit) {
        for (int i = 0; i < lottoDigit; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            printLottoDigit(numbers);
        }
    }

    private void printLottoDigit(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
