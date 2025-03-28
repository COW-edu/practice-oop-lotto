package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.ListUtils.toArrayList;

public class LottoMachine {

    public ArrayList<Lotto> creatLotto(int price){
        int lottoCount = price / 1000;
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = toArrayList(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }
}
