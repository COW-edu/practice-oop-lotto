package lotto.lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoFactory {

    public static final int LOTTO_PRICE = 1000;

    public static List<Lotto> create(int purchasePrice) {
        validate(purchasePrice);
        int size = purchasePrice / LOTTO_PRICE;
        return IntStream.range(0, size).mapToObj(i -> getNewLotto()).collect(Collectors.toList());
    }

    private static Lotto getNewLotto() {
        var numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE, Lotto.SIZE_OF_LOTTO_NUMBERS)
                             .stream()
                             .map(LottoNumber::valueOf)
                             .collect(Collectors.toSet());
        return Lotto.from(numbers);
    }

    private static Set<LottoNumber> createRandomLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>(Lotto.SIZE_OF_LOTTO_NUMBERS);

        while(lottoNumbers.size() < Lotto.SIZE_OF_LOTTO_NUMBERS) {
            var newLottoNumber = LottoNumber.getRandomInstance();
            lottoNumbers.add(newLottoNumber);
        }

        return lottoNumbers;
    }

    private static void validate(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE || purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 가격을 확인해주세요.");
        }
    }

}
