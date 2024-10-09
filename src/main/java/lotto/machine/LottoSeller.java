package lotto.machine;

import lotto.constant.Error;

import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {
    int DEFAULT_AMOUNT = 1000;

    public List<Lotto> sellLotto(int amount) {
        if (amount % DEFAULT_AMOUNT != 0) {
            throw new IllegalArgumentException(Error.ERROR_INVALID_AMOUNT.getMessage());
        }
        int ticketCount = amount / DEFAULT_AMOUNT;
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // 로또 티켓을 생성
        List<Lotto> lottoTickets = java.util.stream.IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(generator.generateRandomNumbers()))
                .collect(Collectors.toList());

        return lottoTickets;
    }
}
