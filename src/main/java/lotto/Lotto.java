package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> buy(int money) {
        int lottoCount = money / LottoConstants.LOTTO_PRICE;
        return generate(lottoCount);
    }

    public static List<Lotto> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(
                                LottoConstants.LOTTO_NUMBER_MIN,
                                LottoConstants.LOTTO_NUMBER_MAX,
                                LottoConstants.LOTTO_NUMBER_COUNT)
                ))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT || new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호입니다.");
        }
    }
}
