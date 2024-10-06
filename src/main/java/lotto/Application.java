// 3주차 코드입니다 2주차로 잘못올려서 다시올립니다 ㅜㅜ

package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int pricePerLotto = 1000;

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            validatePurchaseAmount(purchaseAmount);
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
        String inputPurchaseAmount = "구입금액을 입력해 주세요.";
        System.out.println(inputPurchaseAmount);
        return Integer.parseInt(Console.readLine());
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            String negativePurchaseAmountError = "[ERROR] 구입 금액은 음수가 될 수 없습니다.";
            throw new IllegalArgumentException(negativePurchaseAmountError);
        }
        if (purchaseAmount % pricePerLotto != 0) {
            String multiplesPurchaseAmountError = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
            throw new IllegalArgumentException(multiplesPurchaseAmountError);
        }
    }

    private static List<Lotto> generateLotto(int purchaseAmount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        int numberOfLotto = purchaseAmount / pricePerLotto;
        String purchasedNumberOfLotto = numberOfLotto + "개를 구매했습니다.";
        System.out.println(purchasedNumberOfLotto);
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
        String inputWinningNumbers = "당첨 번호를 입력해주세요.";
        System.out.println(inputWinningNumbers);
        List<Integer> winningNumbers = parseInputNumbers(Console.readLine());
        new Lotto(winningNumbers);
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        String inputBonusNumber = "보너스 번호를 입력해주세요.";
        System.out.println(inputBonusNumber);
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
        String printResults = "총 수익률은 " + yield + "%입니다.";
        System.out.println(printResults);
    }

    private static int[] countRanks(List<LottoRank> results) {
        int[] rankCount = new int[LottoRank.values().length];
        for (LottoRank rank : results) {
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
    }

    private static void printRankResults(int[] rankCount) {
        String printRankResultsHeader = "당첨 통계\n---";
        System.out.println(printRankResultsHeader);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                String printRankResults = rank.getResultMessage() + " - " + rankCount[rank.ordinal()] + "개";
                System.out.println(printRankResults);
            }
        }
    }
}