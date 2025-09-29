package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult rankAll(WinningLotto winningLotto) {
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.determineRank(winningLotto);
            //해당 rank에 누적 더하기
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(rankMap);
    }

}
