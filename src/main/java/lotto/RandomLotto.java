package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.*;

public class RandomLotto {

    private List<Integer> lottoNumbers;
    private List<Integer> lotto = new ArrayList<>();

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
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT_RANGE);
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
//        Collections.sort(lottoNumbers);
//        return lottoNumbers;
    }
}
