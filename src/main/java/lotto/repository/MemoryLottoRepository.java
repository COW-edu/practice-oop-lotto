package lotto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import lotto.entity.Lotto;

public class MemoryLottoRepository implements LottoRepository {

    private final HashMap<Long, Lotto> userLotto = new HashMap<>();
    private List<Lotto> lottoList;

    public MemoryLottoRepository() {

    }


    public void add(int i, Lotto lotto) {
        userLotto.put((long) i, lotto);
    }

    @Override
    public List<Lotto> getLottoList() {
        lottoList = new ArrayList<>();
        userLotto.forEach((aLong, lotto) -> lottoList.add(lotto));
        return lottoList;
    }

    @Override
    public void saveLotto(ArrayList<Lotto> lottos) {
        IntStream.range(0, lottos.size()).forEach(i -> {
            add(i + 1, lottos.get(i));
        });
    }

}
