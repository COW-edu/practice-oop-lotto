package domain;

import enums.ErrorMessage;
import enums.Rank;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateNull(winningLotto, bonusNumber);
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    // 6. 검증 - 당첨번호와 보너스번호가 중복인지, Null인지
    private void validateNull(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto == null || bonusNumber == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE.getMessage());
        }
    }
    private void validateDuplicate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    // 7-4. 당첨번호와 보너스번호를 비교하여 등수 반환
    public Rank match(Lotto userLotto) {
        // 로또번호와 당첨번호 비교해서 일치개수 확인
        int matchCount = userLotto.matchCount(winningLotto);
        // 보너스 번호 포함 확인
        boolean matchBonus = userLotto.contains(bonusNumber.getNumber());
        // 등수 반환
        return Rank.of(matchCount, matchBonus);
    }
}
