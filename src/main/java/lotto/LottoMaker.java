package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    List<List<Integer>> lottoSaved = new ArrayList<>();
    //생성된 로또 숫자는 배열에 저장
    private List<Integer> makeNum() {
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


    public void generate(int amount) {

        //숫자 받아서 그만큼 로또 생성하기
        for (int i = 0; i < amount; i++) {
            List<Integer> lotto = makeNum();
            System.out.println(lotto);
            lottoSaved.add(lotto);
        }

    }


}
