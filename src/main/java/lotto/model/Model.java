package lotto.model;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.LottoRank;
import lotto.global.Validator;
import lotto.global.Constant.LottoConstant;

public class Model {

    private int money;
    private int[] correctLotto;
    private int lottoCount;
    private int bonus;
    private ArrayList<Lotto> lottos;
    private HashMap<LottoRank, Integer> lottoResult;
    public Model(){
        money = 0;
        correctLotto = new int[LottoConstant.LOTTO_COUNT];
        lottoCount = 0;
        bonus = 0;
        lottos = new ArrayList<Lotto>();
        lottoResult = new HashMap<>();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int gold, int unit) {
        Validator.checkUnitMoney(gold,unit);
        lottoCount = gold/unit;
        this.money = gold;
    }
    public int[] getCorrectLotto() {
        return correctLotto;
    }
    public void setCorrectLotto(int[] correctLotto) {
        this.correctLotto = correctLotto;
    }
    public void setCorrectLotto(String correctLotto) {
        StringTokenizer token = new StringTokenizer(correctLotto,",");
        int count =LottoConstant.LOTTO_COUNT;
        Validator.checkCount(token,count);
        for(int i=0; i<count; i++){
            String num = token.nextToken();
            Validator.checkNumber(num);
            Validator.checkRange(Integer.parseInt(num),LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
            this.correctLotto[i] = Integer.parseInt(num);
        }
        Validator.checkDuplication(this.correctLotto);
    }

    public int getLottoCount() {
        return lottoCount;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        Validator.checkRange(bonus,LottoConstant.LOTTO_MIN,LottoConstant.LOTTO_MAX);
        Validator.checkBonusDuplicate(correctLotto, bonus);
        this.bonus = bonus;
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void makeLotto(){
        for(int i=0; i<lottoCount; i++){
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
            int sameCount = Function.getSameCount(lotto.getNumbers(),correctLotto);
            if(sameCount>=3){
                Optional<LottoRank> rank = LottoRank.valueOf(sameCount, lotto.getNumbers().contains(bonus));
                rank.ifPresent(x -> lottoResult.put(x, lottoResult.get(x)+1));
            }
        }
    }
}

