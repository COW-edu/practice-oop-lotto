package lotto.model;

import java.util.*;

import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private Wallet wallet;
    private WiningNumber winingNumber;
    private Lottos lottos;
    private final LottoResultCalculator lottoResultCalculator;
    private final LottoResultFormatter lottoResultFormatter;
    public Model(){
        lottos = new Lottos();
        lottoResultCalculator = new LottoResultCalculator();
        lottoResultFormatter = new LottoResultFormatter();
    }

    public void setWallet(int gold) {
        wallet = new Wallet(gold);
    }

    public void setWiningLotto(int[] winingNumbers) {

        Validator.checkCount(winingNumbers,LottoConstant.LOTTO_COUNT);

        winingNumber = new WiningNumber(winingNumbers);
    }

    public void setBonus(int bonus) {
        winingNumber.setBonus(bonus);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public void startLotto() {
        lottoResultCalculator.startLotto(lottos.getLottos(), winingNumber.getWiningNumber(), winingNumber.getBonus());
    }

    public String getLottoResult() {
        return lottoResultFormatter.formatLottoResult(wallet.getMoney(), lottoResultCalculator.getLottoResult());
    }

    public void makeLotto(){
        lottos.buyLotto(wallet.getLottoCount());
    }

}

