package lotto.model;

import java.util.*;

import lotto.global.LottoRank;
import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private Wallet wallet;
    private WiningNumber winingNumber;
    private Lottos lottos;
    private final LottoMatchCalculator lottoMatchCalculator;
    private ProfitRateCalculator profitRateCalculator;
    public Model(){
        lottos = new Lottos();
        lottoMatchCalculator = new LottoMatchCalculator();
        profitRateCalculator = new ProfitRateCalculator();
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
        lottoMatchCalculator.startLotto(lottos.getLottos(), winingNumber.getWiningNumber(), winingNumber.getBonus());
        profitRateCalculator.profitRateCalculate(wallet.getMoney(), lottoMatchCalculator.getLottoResult());
    }

    public void makeLotto(){
        lottos.buyLotto(wallet.getLottoCount());
    }

    public Map<LottoRank, Integer> getLottoResult(){
        return lottoMatchCalculator.getLottoResult();
    }
    public float getProfitRate(){
        return profitRateCalculator.getProfitRate();
    }
}

