package lotto.service;

import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.entity.Lotto;
import lotto.entity.WinLotto;

public class JudgementImpl implements Judgement {

    private List<Integer> resultList = new ArrayList<>();

    private WinLotto winLotto;
    private int bonusNumber;

    public List<Integer> resultJudge(List<Lotto> lottoList, WinLotto winLotto, int bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
        lottoList.forEach(lotto -> {
            resultList.add(rowCompare(lotto));
        });
        return resultList;
        
    }

    public Integer rowCompare(Lotto lotto) {
        int count = IntStream.range(0, LOTTO_ROW_SIZE)
            .map(i -> countCheck(lotto, i))
            .sum();
        return count + (count == 5 ? bonusCheck(lotto) : 0);
    }


    public int countCheck(Lotto lotto, int i) {
        if (lotto.getNumbers()
            .contains(winLotto.getWinningLotto().get(i))) {
            return 1;
        }
        return 0;
    }

    public int bonusCheck(Lotto lotto) {
        if (lotto.getNumbers()
            .contains((bonusNumber))) {
            return 2;
        }
        return 0;
    }
}
