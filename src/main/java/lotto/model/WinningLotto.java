package lotto.model;

public class WinningLotto {
	private Lotto winningNumbers;
	private int bonusBall;

	public WinningLotto(Lotto winningNumbers, int bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = bonusBall;
	}

	public Ranking match(Lotto playerNumber) {
		int countOfMatch = playerNumber.countMatch(winningNumbers);
		boolean bonusCheck = playerNumber.containNumber(bonusBall);
		return Ranking.valueOf(countOfMatch, bonusCheck);
	}
}
