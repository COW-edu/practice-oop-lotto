package lotto.service;

import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.WinLotto;

public interface Judgement {

    List<Integer> resultJudge(List<Lotto> lottoList, WinLotto winLotto, int bonusNumber);

}
