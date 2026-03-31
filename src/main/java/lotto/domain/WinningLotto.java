package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonus(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = userLotto.countMatch(winningLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }
}