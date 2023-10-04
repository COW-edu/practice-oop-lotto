package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private Randoms randoms;

    public LottoMachine(){

    }

    public ArrayList<Lotto> playLotto(int count) {
        ArrayList<Lotto> lottoLists = new ArrayList<>();
        for(int i =0;i<count;i++){
            List<Integer> lottoRow = randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoRow);
            Collections.sort(lottoRow);
            lottoLists.add(lotto);
        }
        return lottoLists;
    }
}
