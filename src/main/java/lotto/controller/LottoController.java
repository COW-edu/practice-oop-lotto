package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.model.GenerateNumbers;
import lotto.model.Lotto;
import lotto.model.LottoResultAnalyzer;
import lotto.model.PlayerLottoAmount;
import lotto.model.Ranking;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private static final int TICKET_PRICE = 1000;
	private static final int PERCENTAGE = 100;

	public void run() {
		try {
			start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private void start() {
		int ticketCount = inputPlayerAmount();
		OutputView.printTicketCount(ticketCount);

		List<Lotto> lottoList = makeLottoList(ticketCount);
		WinningLotto winningLotto = inputWinningLotto();

		lottoResult(lottoList, winningLotto, ticketCount);

	}

	public int inputPlayerAmount() {
		PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
		return playerLottoAmount.calculateLottoCount();
	}

	public WinningLotto inputWinningLotto() {
		List<Integer> winningNumbers = InputView.inputLottoWinningNum();
		int ball = InputView.inputBonusNumber();

		Lotto winningLottoNumbers = new Lotto(winningNumbers);

		WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, ball);

		return winningLotto;
	}

	private List<Lotto> makeLottoList(int ticketCount) {
		List<Lotto> lottoList = new ArrayList<>();

		for (int i = 0; i < ticketCount; i++) {
			lottoList.add(makeLotto());
		}
		return lottoList;
	}

	private Lotto makeLotto() {
		List<Integer> immutableLottoNumbers = GenerateNumbers.makeRandomNumbers();
		List<Integer> lottoNumbersList = new ArrayList<>(immutableLottoNumbers);
		Collections.sort(lottoNumbersList);

		OutputView.printLotto(lottoNumbersList);

		return new Lotto(lottoNumbersList);
	}

	private void lottoResult(List<Lotto> lottoList, WinningLotto winningLotto, int amount) {
		LottoResultAnalyzer analyzer = new LottoResultAnalyzer();
		Map<Ranking, Integer> result = analyzer.analyzeResults(lottoList, winningLotto);
		double earningRate = analyzer.calculateEarningRate(result, amount);

		OutputView.printSuccessResult();
		displayRankingResult(result);
		OutputView.printRevenueRate(earningRate);
	}

	private void displayRankingResult(Map<Ranking, Integer> result) {
		for (Ranking rank : Ranking.values()) {
			if (rank.isNotMiss()) {
				OutputView.printRankingResult(rank, result.get(rank));
			}
		}
	}
}
