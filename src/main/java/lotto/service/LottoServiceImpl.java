package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.repository.LottoRepository;
import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public List<Lotto> purchaseLotto(int amount) {
        int numberOfLotto = amount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }

}
