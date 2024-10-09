package lotto_model.data;

import lotto_model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {

    private static final LottoRepositoryImpl instance = new LottoRepositoryImpl();
    private final List<Lotto> lottoSaved;

    private LottoRepositoryImpl() {
        lottoSaved = new ArrayList<>();
    }

    public static LottoRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public List<Lotto> getLottoSaved() {
        return lottoSaved;
    }

    @Override
    public void save(Lotto lotto) {
        lottoSaved.add(lotto);
    }
}
