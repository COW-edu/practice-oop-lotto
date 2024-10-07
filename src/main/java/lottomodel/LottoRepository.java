package lottomodel;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository(); // 싱글턴 인스턴스
    private final List<Lotto> lottoSaved; // Lotto 저장 리스트

    private LottoRepository() {
        lottoSaved = new ArrayList<>();
    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public List<Lotto> getLottoSaved() {
        return lottoSaved;
    }

    public void save(Lotto lotto) {
        lottoSaved.add(lotto);
    }
}
