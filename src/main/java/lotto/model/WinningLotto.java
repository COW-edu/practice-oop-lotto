package lotto.model;

import java.util.List;

public class WinningResult {
	private List<Integer> winningNumbers;
	// private final Lotto lotto;
	private int bonusball;

	public WinningResult(Lotto lotto, int bonusball) {
		this.lotto = lotto;
		this.bonusball = bonusball;
	}

	public Ranking match(Lotto playerNumber) {
		int countOfMatch = playerNumber.countMatch(lotto);
		boolean bonusCheck = playerNumber.containNumber(bonusball);
		return Ranking.valueOf(countOfMatch, bonusCheck);
	}

}
