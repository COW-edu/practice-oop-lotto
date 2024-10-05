package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            boolean validatePurchaseAmount = validatePurchaseAmount(purchaseAmount);
            List<Lotto> purchasedLotto = generateLotto(purchaseAmount);
            printPurchasedLotto(purchasedLotto);
            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();

            List<LottoRank> results = calculateResults(purchasedLotto, winningNumbers, bonusNumber);
            printResults(results, purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static boolean validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수가 될 수 없습니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return true;
    }

    private static List<Lotto> generateLotto(int purchaseAmount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        int numberOfLotto = purchaseAmount / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLotto; i++) {
            purchasedLotto.add(Lotto.generate());
        }
        return purchasedLotto;
    }

    private static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningNumbers = parseInputNumbers(Console.readLine());
        new Lotto(winningNumbers);
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        Lotto.validateRange(bonusNumber);
        return bonusNumber;
    }

    private static List<Integer> parseInputNumbers(String winningNumbers) {
        String[] split = winningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            int number = Integer.parseInt(s.trim());
            numbers.add(number);
        }
        return numbers;
    }

    private static List<LottoRank> calculateResults(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            LottoRank lottoRank = LottoCalculator.calculateRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            results.add(lottoRank);
        }
        return results;
    }

    private static void printResults(List<LottoRank> results, int purchaseAmount) {
        int[] rankCount = countRanks(results);
        printRankResults(rankCount);
        double yield = LottoCalculator.calculateYield(results, purchaseAmount);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private static int[] countRanks(List<LottoRank> results) {
        int[] rankCount = new int[LottoRank.values().length];
        for (LottoRank rank : results) {
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
    }

    private static void printRankResults(int[] rankCount) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.println(rank.getResultMessage() + " - " + rankCount[rank.ordinal()] + "개");
            }
        }
    }
}