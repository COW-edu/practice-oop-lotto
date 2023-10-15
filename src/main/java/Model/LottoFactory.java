package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    public static Lotto makeLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
