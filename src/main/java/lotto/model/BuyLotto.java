package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private ArrayList<Lotto> lottos;
    public BuyLotto() {
        lottos = new ArrayList<>();
    }
    public void buyLotto(int lottoCount){
        for(int i=0; i< lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LottoConstant.LOTTO_MIN, Constant.LottoConstant.LOTTO_MAX, Constant.LottoConstant.LOTTO_COUNT);
            numbers.sort(null);
            lottos.add(new Lotto(numbers));
        }
    }
    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
