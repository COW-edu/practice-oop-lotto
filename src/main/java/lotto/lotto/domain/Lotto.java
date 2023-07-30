package lotto.lotto.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Getter
@EqualsAndHashCode(of = "numbers")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Lotto {

    public static final int SIZE_OF_LOTTO_NUMBERS = 6;
    private static final AtomicInteger idGenerator = new AtomicInteger();

    private final String id = String.valueOf(idGenerator.incrementAndGet());
    private final Set<LottoNumber> numbers;
    private LottoReward reward;

    public Lotto(List<Integer> numbers) {
        Set<LottoNumber> numberSet = numbers
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
        validate(numberSet);

        this.numbers = numberSet;
    }

    public static Lotto from(Set<LottoNumber> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    public boolean isWin() {
        return reward != null;
    }


    public void finish(LottoReward reward) {
        if (this.reward == null && reward != null) {
            this.reward = reward;
        }
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호들의 개수가 맞지 않습니다.");
        }
    }
}
