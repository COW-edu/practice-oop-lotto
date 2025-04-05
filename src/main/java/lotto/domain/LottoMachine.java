package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine (LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> generateLottoNumbers = lottoNumberGenerator.generateLottoNumbers();
            lottos.add(new Lotto(generateLottoNumbers));
        }
        return lottos;
    }
}