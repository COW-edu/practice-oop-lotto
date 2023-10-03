package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
//        validate(numbers);
    }
    public List<Integer> getLottoList() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    public List<Lotto> createLottoNum(int purchaseAmount) {
        List<Lotto> selectedLottoNum = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            Lotto lotto = new Lotto(camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6));
            selectedLottoNum.add(lotto);
        }
        return selectedLottoNum;
    }
}
