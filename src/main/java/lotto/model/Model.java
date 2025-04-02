package lotto.model;

import java.util.*;

import lotto.global.LottoRank;
import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private HashMap<LottoRank, Integer> lottoResult;
    private Wallet wallet;
    private MatchLotto matchLotto;
    private BuyLotto buyLotto;
    public Model(){
        lottoResult = new HashMap<>();
        buyLotto = new BuyLotto();
    }

    public int getMoney() {
        return wallet.getMoney();
    }

    public void setWallet(int gold) {
        wallet = new Wallet(gold);
    }
    public int[] getCorrectLotto() {
        return matchLotto.getCorrectNumbers();
    }
    public void setCorrectLotto(String correctLotto) {
        StringTokenizer token = new StringTokenizer(correctLotto,",");
        Validator.checkCount(token,LottoConstant.LOTTO_COUNT);
        int[] correctNumbers = new int[LottoConstant.LOTTO_COUNT];
        for(int i=0; i<LottoConstant.LOTTO_COUNT; i++){
            String num = token.nextToken();
            Validator.checkNumber(num);
            correctNumbers[i] = Integer.parseInt(num);
        }
        matchLotto = new MatchLotto(correctNumbers);
    }

    public int getLottoCount() {
        return wallet.getLottoCount();
    }
    public int getBonus() {
        return matchLotto.getBonus();
    }
    public void setBonus(int bonus) {
        Validator.checkRange(bonus,LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
        Validator.checkBonusDuplicate(matchLotto.getCorrectNumbers(), bonus);
        matchLotto.setBonus(bonus);
    }

    public List<Lotto> getLottos() {
        return buyLotto.getLottos();
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void makeLotto(){
        buyLotto.buyLotto(wallet.getLottoCount());
    }
    public void startLotto(){
        for(LottoRank rank : LottoRank.values()){
            lottoResult.put(rank, 0);
        }
        for(Lotto lotto : buyLotto.getLottos()){
            int sameCount = Function.getSameCount(lotto.getNumbers(), matchLotto.getCorrectNumbers());
            if(sameCount>=3){
                Optional<LottoRank> rank = LottoRank.valueOf(sameCount, lotto.getNumbers().contains(matchLotto.getBonus()));
                rank.ifPresent(x -> lottoResult.put(x, lottoResult.get(x)+1));
            }
        }
    }
}

