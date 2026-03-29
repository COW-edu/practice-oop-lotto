package lotto;

import java.util.*;

public class Application {
    private static double calculateProfitRate(Map<Rank, Integer> result, int purchaseAmount) {
        long totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += (long) rank.getPrize() * count;
        }

        return (double) totalPrize / purchaseAmount * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Check checkMoney = new CheckMoney();
        Check checkNumber = new CheckNumber();
        RandomLotto randomLotto = new RandomLotto();

        System.out.println("구입금액을 입력해 주세요.");

        int num = sc.nextInt();

        if (!checkMoney.checkNum(num)) {
            throw new IllegalArgumentException();
        }
        int count = (num / 1000);

        System.out.println("\n"+ count + "개를 구매했습니다.");

        List<List<Integer>> randLotto = new ArrayList<>();
        for (int i=0; i<count; i++) {
            List<Integer> rLotto = randomLotto.generate();

            System.out.println(rLotto);
            randLotto.add(rLotto);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = sc.next();
        String[] numbers = input.split(",");
        List<Integer> inputNum = new ArrayList<>();
        for (String n : numbers) {
            Integer a = Integer.parseInt(n);
            if (!checkNumber.checkNum(a)) {
                throw new IllegalArgumentException();
            }
            inputNum.add(a);
        }

        Lotto WinningLotto = new Lotto(inputNum);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int BonusNum = sc.nextInt();

        Map<Rank, Integer> result = new HashMap<>();
        for (List<Integer> lotto : randLotto) {
            int matchCount = (int) lotto.stream()
                    .filter(inputNum::contains)
                    .count();
            boolean bonusMatch = lotto.contains(BonusNum);

            Rank rank = Rank.of(matchCount, bonusMatch);
            if (rank != Rank.MISS) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        // 결과 출력
        System.out.println("\n당첨 통계");
        System.out.println("---");

        List<Rank> printOrder = List.of(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
        );

        for (Rank rank : printOrder) {
            int rankCount = result.getOrDefault(rank, 0);
            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    rank.getMatchCount(),
                    rank.isBonusMatch() ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    rankCount
            );
        }

        double profitRate = calculateProfitRate(result, num);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }


}
