package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> purchasedLotto = generateLotto(purchaseAmount); // 로또 티켓 생성
            printPurchasedLotto(purchasedLotto); // 생성된 로또 번호 출력
            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();

            List<LottoRank> results = calculateResults(purchasedLotto, winningNumbers, bonusNumber);
            printResults(results, purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Step 1: Input purchase amount
    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    // Step 2: Generate lotto tickets
    private static List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> purchasedLotto = new ArrayList<>();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLotto; i++) {
            purchasedLotto.add(Lotto.generate()); // 로또 번호 생성
        }
        return purchasedLotto; // 생성된 로또 리스트 반환
    }

    // Step 3: Print purchased lotto tickets
    private static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers()); // 생성된 로또 번호 출력
        }
    }

    // Step 4: Input winning numbers
    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseInputNumbers(Console.readLine());
        new Lotto(winningNumbers); // Lotto 객체를 생성하며 번호 검증
        return winningNumbers;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        Lotto.validateRange(bonusNumber); // 범위 검증
        return bonusNumber;
    }

    // 문자열을 숫자 리스트로 변환
    private static List<Integer> parseInputNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            int number = Integer.parseInt(s.trim());
            numbers.add(number);
        }
        return numbers;
    }

    // Step 5: Calculate result
    private static List<LottoRank> calculateResults(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            LottoRank rank = LottoCalculator.calculateRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            results.add(rank);
        }
        return results;
    }

    // Step 6: Print results
    private static void printResults(List<LottoRank> results, int purchaseAmount) {
        int[] rankCount = countRanks(results);
        displayRankResults(rankCount);
        double yield = LottoCalculator.calculateYield(results, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static int[] countRanks(List<LottoRank> results) {
        int[] rankCount = new int[LottoRank.values().length];
        for (LottoRank rank : results) {
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
    }

    private static void displayRankResults(int[] rankCount) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.println(rank.getResultMessage() + " - " + rankCount[rank.ordinal()] + "개");
            }
        }
    }
}