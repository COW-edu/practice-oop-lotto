package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

    private List<Integer> lottoNumbers;
    private List<Integer> lotto = new ArrayList<>();

    private static final int startRange = 1;
    private static final int endRange = 45;
    private static final int countRange = 6;

    public RandomLotto() {
        // 로또 번호 랜덤 생성
    }

    public List<Lotto> makeList(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<count; i++) {
            lottos.add(makeLottos());
        }
        return lottos;
    }

    private Lotto makeLottos() {
        lotto = selecting();
        return new Lotto(lotto);
    }

    public List<Integer> selecting() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(startRange, endRange, countRange);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
