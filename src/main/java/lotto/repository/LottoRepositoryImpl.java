package lotto.repository;

import lotto.model.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {

    private final List<Lotto> lottoStorage = new ArrayList<>();

    @Override
    public void saveLotto(Lotto lotto) {
        lottoStorage.add(lotto);
    }

    @Override
    public List<Lotto> findAllLotto() {
        return new ArrayList<>(lottoStorage);
    }
}
