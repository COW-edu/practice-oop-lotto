package controller;

import model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottos(int amount) {
        int lottoAmount = calculateLottoAmount(amount);

        List<Lotto> lottos = IntStream.rangeClosed(1, lottoAmount)
                .mapToObj(i -> LottoFactory.makeLotto())
                .collect(Collectors.toList());

        return lottos;
    }

    private int calculateLottoAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
