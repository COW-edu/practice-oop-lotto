package lotto.model;

import lotto.global.LottoRank;

import java.util.*;

public class LottoResultCalculator {
    private final HashMap<LottoRank, Integer> lottoResult;
    private int totalProfitRate;
    public LottoResultCalculator() {
        lottoResult = new HashMap<>();
    }
    public void startLotto(List<Lotto> lottos, int[] winingNumbers, int bonus) {
        for(LottoRank rank : LottoRank.values()){
            lottoResult.put(rank, 0);
        }
        for(Lotto lotto : lottos){
            int sameCount = getSameCount(lotto.getNumbers(), winingNumbers);
            if(sameCount>=3){
                Optional<LottoRank> rank = LottoRank.valueOf(sameCount, lotto.getNumbers().contains(bonus));
                rank.ifPresent(x -> lottoResult.put(x, lottoResult.get(x)+1));
            }
        }
    }

    private int getSameCount(List<Integer> list, int[] array) {
        return (int)list.stream().filter(num -> java.util.Arrays.stream(array).anyMatch(x -> x == num)).count();
    }
    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

}
