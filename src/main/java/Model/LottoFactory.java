package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    static final int LOTTO_NUMBER_MINIMUM = 1;
    static final int LOTTO_NUMBER_MAXIMUM = 45;
    static final int LOTTO_SIZE = 6;

    public static Lotto makeLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_SIZE));
    }
}
