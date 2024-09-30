package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInterFace {

    private static final int LOTTO_PRICE_UNIT = 1000; // 로또 구매 단위 금액
    private static final int WINNING_NUMBER_COUNT = 6; // 당첨 번호 개수
    private static final int LOTTO_MIN_NUMBER = 1; // 로또 번호 최소값
    private static final int LOTTO_MAX_NUMBER = 45; // 로또 번호 최대값

    // 구입 금액 입력받기
    public int inputPurchaseAmount() {
        while (true) {
            try {
                printMessage(Rank.UserMessage.PRICE_GUIDE.getMessage());
                int amount = Integer.parseInt(readInput());

                if (amount % LOTTO_PRICE_UNIT != 0) {
                    throw new IllegalArgumentException(Rank.UserMessage.PRICE_ERROR_MESSAGE.getMessage());
                }
                return amount;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력받기
    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                printMessage(Rank.UserMessage.NUMBER_GUIDE.getMessage());
                String input = readInput();
                List<Integer> winningNumbers = Stream.of(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력받기
    public int inputBonusNumber() {
        while (true) {
            try {
                int bonusNumber = readBonusNumber();
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    // 구입한 로또 출력
    public void printPurchasedLottos(List<Lotto> lottos) {
        printMessage(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    // 당첨 결과 출력
    public void printStatistics(int[] results, Rank[] ranks) {
        printMessage("당첨 통계\n---");
        for (Rank rank : ranks) {
            if (rank == Rank.MISS) continue;
            printMessage(String.format(Rank.UserMessage.CURRENT_MESSAGE.getMessage(),
                    rank.matchCount,
                    rank.matchBonus ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    results[rank.ordinal()]));
        }
    }

    // 에러 메시지 출력
    public void printErrorMessage(String message) {
        printMessage("[ERROR] " + message);
    }

    // 당첨 번호 유효성 검사
    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(Rank.UserMessage.NUMBER_ERROR_MESSAGE1.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(Rank.UserMessage.NUMBER_ERROR_MESSAGE2.getMessage());
        }
    }

    // 보너스 번호 읽기
    private int readBonusNumber() {
        printMessage(Rank.UserMessage.BONUS_NUMBER_GUIDE.getMessage());
        return Integer.parseInt(readInput());
    }

    // 보너스 번호 유효성 검사
    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Rank.UserMessage.BONUS_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    // 출력 메서드 (println 대체)
    private void printMessage(String message) {
        System.out.println(message);
    }

    // 입력 메서드 (readLine 대체)
    private String readInput() {
        return Console.readLine();
    }
}
