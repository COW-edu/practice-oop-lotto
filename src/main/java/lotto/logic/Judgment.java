package lotto.logic;

import static lotto.constant.LottoRule.LOTTO_DISTINCTION_RANGE;
import static lotto.constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.entity.Lotto;
import lotto.entity.WinLottoListClass;

public class Judgment {
    
    private WinLottoListClass winLottoListClass;
    private final ArrayList<Lotto> lottoArrayList;
    private final List<Integer> resultCountlist;
    private final int[] totalResult;


    public Judgment(ArrayList<Lotto> lottoLists, WinLottoListClass winLottoListClass) {
        this.resultCountlist = new ArrayList<>();
        this.totalResult = new int[LOTTO_DISTINCTION_RANGE];
        this.lottoArrayList = lottoLists;
        this.winLottoListClass = winLottoListClass;
    }

    public int[] judgeProduce() {
        resultJudge();
        reportResult();
        return totalResult;
    }

    public void resultJudge() {
        lottoArrayList.forEach(lotto -> {
            resultCountlist.add(rowCompare(lotto));
        });
    }

    public int rowCompare(Lotto lotto) {
        int count = IntStream.range(0, LOTTO_ROW_SIZE)
            .map(i -> countCheck(lotto, i))
            .sum();
        return count + (count == 5 ? bonusCheck(lotto) : 0);
    }


    public int countCheck(Lotto lotto, int i) {
        if (lotto.getNumbers()
            .contains(winLottoListClass.getWinLotto().get(i))) {
            return 1;
        }
        return 0;
    }

    public int bonusCheck(Lotto lotto) {
        if (lotto.getNumbers()
            .contains((winLottoListClass.getBonusNumber()))) {
            return 2;
        }
        return 0;
    }

    private void reportResult() {
        resultCountlist
            .forEach(count -> totalResult[count] += 1);
    }

    public void setWinLottoList(WinLottoListClass winLottoListClass) {
        this.winLottoListClass = winLottoListClass;
    }
}
