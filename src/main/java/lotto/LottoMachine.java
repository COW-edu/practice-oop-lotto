package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lotto.ListUtils.toArrayList;

public class LottoMachine {
    public ArrayList<Lotto> creatLotto(int price){
        int lottoCount = price/1000;
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(toArrayList(Randoms.pickUniqueNumbersInRange(1,45,6))));
        }
        return lottos;
    }
}
