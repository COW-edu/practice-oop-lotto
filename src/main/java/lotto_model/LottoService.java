package lotto_model;

public class LottoService {
    private final LottoComparator lottoComparator;
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoComparator lottoComparator, LottoGenerator lottoGenerator) {
        this.lottoComparator = lottoComparator;
        this.lottoGenerator = lottoGenerator;
    }

    public void lottoCompare(Lotto targetLotto, int bonusNumber) {
        lottoComparator.compare(targetLotto, bonusNumber);
    }

    public void printLotto(int inputMoney) {
        lottoGenerator.printLottoSaved(inputMoney);
    }
}
