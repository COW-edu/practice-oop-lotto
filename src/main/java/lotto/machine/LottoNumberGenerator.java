package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateRandomNumbers() {
        // Randoms API를 사용하여 1 ~ 45 범위의 6개의 중복되지 않은 숫자 생성
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
