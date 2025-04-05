package model;

import camp.nextstep.edu.missionutils.Randoms;
import global.enums.MagicNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MagicNumber.LOTTO_NUMBER_MIN.getValue(),
                MagicNumber.LOTTO_NUMBER_MAX.getValue(),
                MagicNumber.LOTTO_LENGTH.getValue()
        );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static List<Lotto> generateMultiple(int count) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(generate());
        }
        return lotto;
    }
}
