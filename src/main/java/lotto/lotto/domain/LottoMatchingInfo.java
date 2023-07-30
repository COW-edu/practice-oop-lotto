package lotto.lotto.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoMatchingInfo {
    private final int matchedNumbers;
    private final int matchedBonusNumbers;
}
