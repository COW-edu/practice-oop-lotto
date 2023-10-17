package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumbers {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int CNT_LOTTO_NUMBER = 6;

	public static List<Integer> makeRandomNumbers() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
			CNT_LOTTO_NUMBER);

		return lottoNumbers;
	}
}
