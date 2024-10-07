package lotto.machine;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    public List<Lotto> sellLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_AMOUNT);
        }
        int ticketCount = amount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(generator.generateRandomNumbers()));
        }
        return lottoTickets;
    }
}
