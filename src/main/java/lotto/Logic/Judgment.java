package lotto.Logic;

import static lotto.Constant.LottoRule.LOTTO_DISTINCTION_RANGE;
import static lotto.Constant.LottoRule.LOTTO_ROW_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Entity.Lotto;

public class Judgment {
    // 결과 판단 담당
    private ArrayList<Lotto> lottoArrayList;
    private List<Integer> winningLottos;
    private final List<Integer> resultCountlist;
    private final int[] totalResult;


    public Judgment() {
        resultCountlist = new ArrayList<>();
        totalResult = new int[LOTTO_DISTINCTION_RANGE];
        Arrays.fill(totalResult, 0);
    }

    public int[] judgeProduce(ArrayList<Lotto> lottoLists, List<Integer> winningLottos) {
        this.lottoArrayList = lottoLists;
        this.winningLottos = winningLottos;
        judge();
        reportResult();
        return totalResult;
    }

    public void judge() {
        for (Lotto lotto : lottoArrayList) {
            resultCountlist.add(rowCompare(lotto));
        }
    }

    public int rowCompare(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_ROW_SIZE; i++) {
            count += countCheck(lotto, i);
        }
        if (count == 5) {
            count += bonusCheck(lotto);
        }
        return count;
        // 일치하는 개수
    }

    private int countCheck(Lotto lotto, int i) {
        if (lotto.getNumbers().contains(winningLottos.get(i))) {
            return 1;
        }
        return 0;
    }

    private int bonusCheck(Lotto lotto) {
        if (lotto.getNumbers().contains((winningLottos.get(6)))) {
            return 2;
        }
        return 0;
    }
    
    private void reportResult() {
        for (Integer count : resultCountlist) {
            totalResult[count] += 1;
        }
    }
}
