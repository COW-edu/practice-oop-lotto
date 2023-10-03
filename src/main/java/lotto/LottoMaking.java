package lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaking {
    public static Lotto MakeLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
