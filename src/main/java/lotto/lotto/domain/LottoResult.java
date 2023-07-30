package lotto.lotto.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoResult {
    public static final String NOT_VALID_LOTTO_RESULT_ERROR_MESSAGE = "당첨 번호와 보너스 번호를 확인해주세요.";

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public static LottoResult of(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        validate(numbers, bonusNumber);
        return new LottoResult(numbers, bonusNumber);
    }

    private static void validate(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber) || numbers.size() != Lotto.SIZE_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NOT_VALID_LOTTO_RESULT_ERROR_MESSAGE);
        }
    }

    public boolean containWinningNumbers(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean containBonusNumbers(LottoNumber lottoNumber) {
        return lottoNumber.equals(bonusNumber);
    }
}
