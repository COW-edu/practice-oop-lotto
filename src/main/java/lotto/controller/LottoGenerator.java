package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.utils.LottoConstants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public List<Lotto> buy(int money) {
        int lottoCount = money / LottoConstants.LOTTO_PRICE;
        return generate(lottoCount);
    }

    private List<Lotto> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(
                                LottoConstants.LOTTO_NUMBER_MIN,
                                LottoConstants.LOTTO_NUMBER_MAX,
                                LottoConstants.LOTTO_NUMBER_COUNT)
                ))
                .collect(Collectors.toList());
    }
}