package lotto.service;
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
            Lotto lotto = lottoRepository.createLotto();
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }




}
