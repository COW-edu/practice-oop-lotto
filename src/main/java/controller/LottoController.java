package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.*;

public class LottoController {

    private List<Lotto> lottos;
    private Lotto selectLotto;

    private List<Integer> lottoNumbers;
    private List<Integer> lotto = new ArrayList<>();

    public LottoController() {

    }

    public List<Lotto> makeRandomLottos(int count) {
        lottos = makeList(count);
        return lottos;
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
    }

    public Lotto makeCustomerLotto(List<Integer> selectLottoNumber) {
        this.selectLotto = new Lotto(selectLottoNumber);
        return selectLotto;
    }

}
