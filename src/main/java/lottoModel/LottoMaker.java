package lottoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    static List<List<Integer>> lottoSaved = new ArrayList<>();
    private static List<Integer> createNum() {
        List<Integer> lottoNum = new ArrayList<>();
        while (lottoNum.size() < 6) {
            int lotto = (int) ((Math.random() * 45) + 1);
            if (!lottoNum.contains(lotto)) {
                lottoNum.add(lotto);
            }
        }
        Collections.sort(lottoNum); //정렬 추가
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
