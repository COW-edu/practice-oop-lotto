package lotto.model;

import java.util.*;

import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private Wallet wallet;
    private WiningNumber winingNumber;
    private Lottos lottos;
    private final LottoResultCalculator lottoResultCalculator;
    public Model(){
        lottos = new Lottos();
        lottoResultCalculator = new LottoResultCalculator();
    }

    public void setWallet(int gold) {
        wallet = new Wallet(gold);
    }

    public void setWiningLotto(String correctLotto) {
        StringTokenizer token = new StringTokenizer(correctLotto,",");
        Validator.checkCount(token,LottoConstant.LOTTO_COUNT);
        int[] correctNumbers = new int[LottoConstant.LOTTO_COUNT];
        for(int i=0; i<LottoConstant.LOTTO_COUNT; i++){
            String num = token.nextToken();
            Validator.checkNumber(num);
            correctNumbers[i] = Integer.parseInt(num);
        }
        winingNumber = new WiningNumber(correctNumbers);
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
        return LottoResultFormatter.formatLottoResult(wallet.getMoney(), lottoResultCalculator.getLottoResult());
    }

    public void makeLotto(){
        lottos.buyLotto(wallet.getLottoCount());
    }

}

