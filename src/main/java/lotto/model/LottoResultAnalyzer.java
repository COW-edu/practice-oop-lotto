package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultAnalyzer {

	public Map<Ranking, Integer> analyzeResults(List<Lotto> lottoList, WinningLotto winningLotto) {
		Map<Ranking, Integer> result = initializeResult();

		for (Lotto lotto : lottoList) {
			Ranking rank = winningLotto.match(lotto);
			result.put(rank, result.get(rank) + 1);
		}

		return result;
	}

	public double calculateEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
		double earningRate = 0;
		final int TICKET_PRICE = 1000;
		final int PERCENTAGE = 100;

		for (Ranking rank : result.keySet()) {
			earningRate +=
				((double)(rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(rank))) * PERCENTAGE;
		}

		return earningRate;
	}

	private Map<Ranking, Integer> initializeResult() {
		Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
		for (Ranking rank : Ranking.values()) {
			result.put(rank, 0);
		}

		return result;
	}

}
