package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.LottoResultAnalyzer;
import lotto.model.Ranking;
import lotto.model.WinningLotto;

class LottoResultAnalyzerTest {

	private final LottoResultAnalyzer analyzer = new LottoResultAnalyzer();

	@DisplayName("로또 결과 분석이 올바르게 수행된다.")
	@Test
	void analyzeResultsTest() {
		// 당첨 번호와 보너스 볼 설정
		Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

		// 플레이어 로또 티켓 예제
		List<Lotto> lottoList = Arrays.asList(
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
			new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11))
		);

		Map<Ranking, Integer> result = analyzer.analyzeResults(lottoList, winningLotto);

		assertThat(result.get(Ranking.FIRST)).isEqualTo(1);
		assertThat(result.get(Ranking.SECOND)).isEqualTo(1);
		assertThat(result.get(Ranking.THIRD)).isEqualTo(1);
		assertThat(result.get(Ranking.FIFTH)).isEqualTo(1);
	}

	@DisplayName("로또 수익률 계산이 올바르게 수행된다.")
	@Test
	void calculateEarningRateTest() {
		Map<Ranking, Integer> sampleResults = new EnumMap<>(Ranking.class);
		sampleResults.put(Ranking.FIRST, 1);
		sampleResults.put(Ranking.SECOND, 1);
		sampleResults.put(Ranking.THIRD, 1);
		sampleResults.put(Ranking.FOURTH, 0);
		sampleResults.put(Ranking.FIFTH, 0);
		sampleResults.put(Ranking.MISS, 0);

		int lottoAmount = 3;

		double earningRate = analyzer.calculateEarningRate(sampleResults, lottoAmount);

		double expectedRate = (2000000000.0 + 30000000.0 + 1500000.0) / 3000 * 100;

		assertThat(earningRate).isEqualTo(expectedRate);
	}
}
