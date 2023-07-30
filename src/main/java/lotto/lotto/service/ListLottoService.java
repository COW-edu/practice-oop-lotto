package lotto.lotto.service;

import lombok.RequiredArgsConstructor;
import lotto.lotto.domain.Lotto;
import lotto.lotto.port.in.ListLottoUseCase;
import lotto.lotto.port.out.LottoRepository;

import java.util.List;

@RequiredArgsConstructor
public class ListLottoService implements ListLottoUseCase {

    private final LottoRepository lottoRepository;

    @Override
    public List<Lotto> listAllLotto() {
        return lottoRepository.findAll();
    }
}
