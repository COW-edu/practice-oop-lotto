package lotto.view;

import java.util.List;

import lotto.model.Ranking;

public class OutputView {

	public static void printTicketCount(int count) {
		System.out.println(count + "개를 구매했습니다.");
	}

	public static void printSuccessResult() {
		System.out.println("당첨 통계");
		System.out.println("---");
	}

	public static void printSuccessMessage(String message, int numberOfMatch) {
		System.out.println(message + numberOfMatch + "개");
	}

	public static void printRevenueRate(double EarningRate) {
		System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
	}

	public static void printLotto(List<Integer> lottoNumbers) {
		System.out.println(lottoNumbers);
	}

	public static void printRankingResult(Ranking rank, Integer count) {
		printSuccessMessage(rank.getMessage(), count);
	}
}
