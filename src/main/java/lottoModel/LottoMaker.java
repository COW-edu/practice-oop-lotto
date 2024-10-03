package lottoModel;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    static List<List<Integer>> lottoSaved = new ArrayList<>();
    private static List<Integer> createNum() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNum);
        return lottoNum;
    }


    public static void generate(int amount) {

        for (int i = 0; i < amount; i++) {
            List<Integer> lotto = createNum();
            System.out.println(lotto);
            lottoSaved.add(lotto);
        }

    }


}
