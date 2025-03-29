package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);

        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);

        if (lottoNumbersSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR]당첨 번호 6개는 모두 서로 달라야 합니다");
        }

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
