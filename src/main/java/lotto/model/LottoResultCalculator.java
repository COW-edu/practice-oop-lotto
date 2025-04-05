package lotto.model;

import lotto.global.LottoRank;

import java.util.*;

public class LottoResultCalculator {
    private final HashMap<LottoRank, Integer> lottoResult;
    public LottoResultCalculator() {
        lottoResult = new HashMap<>();
    }
    public void startLotto(List<Lotto> lottos, int[] winingNumbers, int bonus) {
        for(LottoRank rank : LottoRank.values()){
            lottoResult.put(rank, 0);
        }
        for(Lotto lotto : lottos){
            int sameCount = Function.getSameCount(lotto.getNumbers(), winingNumbers);
            if(sameCount>=3){
                Optional<LottoRank> rank = LottoRank.valueOf(sameCount, lotto.getNumbers().contains(bonus));
                rank.ifPresent(x -> lottoResult.put(x, lottoResult.get(x)+1));
            }
        }
    }
    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

}
