package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> generateLottos (int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> generateLottoNumbers = LottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(generateLottoNumbers);
            lottos.add(lotto);
        }

        return lottos;

    }
}
