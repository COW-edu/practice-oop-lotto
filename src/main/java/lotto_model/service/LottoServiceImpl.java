package lotto_model.service;

import lotto_model.comparator.LottoComparator;
import lotto_model.generator.LottoGenerator;
import lotto_model.lotto.Lotto;

public class LottoServiceImpl implements LottoService {
    private final LottoComparator lottoComparator;
    private final LottoGenerator lottoGenerator;

    public LottoServiceImpl(LottoComparator lottoComparator, LottoGenerator lottoGenerator) {
        this.lottoComparator = lottoComparator;
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public void lottoCompare(Lotto targetLotto, int bonusNumber) {
        lottoComparator.compare(targetLotto, bonusNumber);
    }

    @Override
    public void printLotto(int inputMoney) {
        lottoGenerator.printLottoSaved(inputMoney);
    }
}
