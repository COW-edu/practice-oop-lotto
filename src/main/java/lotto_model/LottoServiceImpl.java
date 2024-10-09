package lotto_model;

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
