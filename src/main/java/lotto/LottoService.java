package lotto;

public class LottoService {
    private final LottoCounter lottoCounter;
    private final LottoNumberCreater lottoNumberCreater;
    private final LottoWinNumberCreater lottoWinNumberCreater;
    private final ResultView resultView;

    public LottoService() {
        LottoView view = new LottoView();
        this.lottoNumberCreater = new LottoNumberCreater(view);
        this.lottoCounter = new LottoCounter(view);
        this.lottoWinNumberCreater = new LottoWinNumberCreater();
        this.resultView = new ResultView();
    }

    public void run() {
        int lottoCount = lottoCounter.getLottoCount();

        lottoNumberCreater.numberCreate(lottoCount);
        lottoWinNumberCreater.createLottoWinNumber();

        Lotto lotto = new Lotto(lottoWinNumberCreater.getLottoWinNumber());

        LottoResult result = lotto.compareLottoNumbers(
                lottoNumberCreater.getLottoNumbers(),
                lottoWinNumberCreater.getBounsNumber(),
                lottoCount * 1000
        );

        resultView.printStatistics(result);
    }
}
