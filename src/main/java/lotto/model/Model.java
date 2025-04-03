package lotto.model;

import java.util.*;

import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private Wallet wallet;
    private WiningNumber winingNumber;
    private BuyLotto buyLotto;
    private LottoResultCalculator lottoResultCalculator;
    public Model(){
        buyLotto = new BuyLotto();
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
        Validator.checkRange(bonus,LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
        Validator.checkBonusDuplicate(winingNumber.getWiningNumber(), bonus);
        winingNumber.setBonus(bonus);
    }

    public List<Lotto> getLottos() {
        return buyLotto.getLottos();
    }

    public void startLotto() {
        lottoResultCalculator.startLotto(buyLotto.getLottos(), winingNumber.getWiningNumber());
    }

    public String getLottoResult() {
        lottoResultCalculator.startLotto(buyLotto.getLottos(), winingNumber.getWiningNumber());
        return LottoResultFormatter.formatLottoResult(wallet.getMoney(), lottoResultCalculator.getLottoResult());
    }

    public void makeLotto(){
        buyLotto.buyLotto(wallet.getLottoCount());
    }

}

