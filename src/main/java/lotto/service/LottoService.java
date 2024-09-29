package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public interface LottoService {
    List<Lotto> purchaseLotto(int amount);

}
