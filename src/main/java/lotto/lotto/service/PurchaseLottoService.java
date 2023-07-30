package lotto.lotto.service;

import lombok.RequiredArgsConstructor;
import lotto.lotto.domain.LottoFactory;
import lotto.lotto.port.in.PurchaseLottoUseCase;
import lotto.lotto.port.out.LottoRepository;

@RequiredArgsConstructor
public class PurchaseLottoService implements PurchaseLottoUseCase {

    private final LottoRepository lottoRepository;

    @Override
    public void purchase(int purchasePrice) {
        var purchasedLotto = LottoFactory.create(purchasePrice);
        lottoRepository.saveAll(purchasedLotto);
    }
}
