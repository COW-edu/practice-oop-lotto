package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.Constant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private ArrayList<Lotto> lottos;
    public Lottos() {
        lottos = new ArrayList<>();
    }
    public void buyLotto(int lottoCount){
        for(int i=0; i< lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                    (LottoConstant.LOTTO_MIN, LottoConstant.LOTTO_MAX, LottoConstant.LOTTO_COUNT);
            numbers.sort(null);
            lottos.add(new Lotto(numbers));
        }
    }
    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
