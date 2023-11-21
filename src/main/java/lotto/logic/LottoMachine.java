package lotto.logic;

import java.util.ArrayList;
import lotto.entity.Lotto;

public interface LottoMachine {

    ArrayList<Lotto> playLotto(int count);
}
