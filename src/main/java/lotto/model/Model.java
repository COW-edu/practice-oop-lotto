package lotto.model;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.LottoRank;
import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private ArrayList<Lotto> lottos;
    private HashMap<LottoRank, Integer> lottoResult;
    private Wallet wallet;
    private MatchLotto matchLotto;
    public Model(){
        lottos = new ArrayList<Lotto>();
        lottoResult = new HashMap<>();
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

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void makeLotto(){
        for(int i=0; i< wallet.getLottoCount(); i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN, LottoConstant.LOTTO_MAX, LottoConstant.LOTTO_COUNT);
            numbers.sort(null);
            lottos.add(new Lotto(numbers));
        }
    }
    public void startLotto(){
        for(LottoRank rank : LottoRank.values()){
            lottoResult.put(rank, 0);
        }
        for(Lotto lotto : lottos){
            int sameCount = Function.getSameCount(lotto.getNumbers(), matchLotto.getCorrectNumbers());
            if(sameCount>=3){
                Optional<LottoRank> rank = LottoRank.valueOf(sameCount, lotto.getNumbers().contains(matchLotto.getBonus()));
                rank.ifPresent(x -> lottoResult.put(x, lottoResult.get(x)+1));
            }
        }
    }
}

