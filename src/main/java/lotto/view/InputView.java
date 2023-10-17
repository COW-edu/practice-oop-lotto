package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	
	public static String inputPlayerAmount() {
		System.out.println(INPUT_LOTTO_AMOUNT);
		return Console.readLine();
	}

	public static List<Integer> inputLottoWinningNum() {
		System.out.println(INPUT_LOTTO_WINNING);
		return numberList(Console.readLine());
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		return Integer.valueOf(Console.readLine());
	}

	public static List<Integer> numberList(String winningNumber) {
		return Stream.of(winningNumber.split(","))
			.map(String::trim)
			.map(InputView::convertToInt)
			.collect(Collectors.toList());
	}

	private static int convertToInt(String inputNumber) {
		try {
			return Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			ExceptionMessage.typeException();
			throw new IllegalArgumentException();
		}
	}
}
