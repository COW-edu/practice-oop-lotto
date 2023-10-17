package Util;

import Model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;
    public static final int LOTTO_SIZE = 6;

    public static Lotto makeLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_SIZE));
    }
}
