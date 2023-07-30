package lotto.lotto.domain;

import lombok.*;

import java.util.Random;

/**
 * Lotto 번호를 저장하는  VO
 */
@Getter
@EqualsAndHashCode(of = "value")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoNumber {

    private static final String ERROR_MESSAGE = "잘못된 로또번호가 입력되었습니다.";

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private static final LottoNumber[] CACHE = new LottoNumber[MAX_VALUE + 1];

    private final int value;


    public static LottoNumber getRandomInstance() {
        var random = new Random();
        var randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        return valueOf(randomNumber);
    }

    public static LottoNumber valueOf(int value) {
        validate(value);

        if (CACHE[value] == null) {
            CACHE[value] = new LottoNumber(value);
        }

        return CACHE[value];
    }

    private static void validate(int value) {
        if (value < MIN_VALUE || MAX_VALUE < value) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
