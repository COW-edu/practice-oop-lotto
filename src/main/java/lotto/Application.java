package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.Check;

import java.util.*;

public class Application {
    private static double calculateProfitRate(Map<Rank, Integer> result, int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount * 100;
    }

    public static void main(String[] args) {
        RandomLotto randomLotto = new RandomLotto();



        // 로또 생성
        int count = num / 1000;
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<List<Integer>> randLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> rLotto = randomLotto.generate();
            System.out.println(rLotto);
            randLotto.add(rLotto);
        }

        // 당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        List<Integer> inputNum = new ArrayList<>();
        for (String n : numbers) {
            int a = Integer.parseInt(n.trim());
            if (!checkNumber.checkNum(a)) {
                throw new IllegalArgumentException("[ERROR] 번호는 1~45 사이여야 합니다.");
            }
            inputNum.add(a);
        }
        Lotto winningLotto = new Lotto(inputNum);

        // 보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        // 당첨 계산
        Map<Rank, Integer> result = new HashMap<>();
        for (List<Integer> lotto : randLotto) {
            int matchCount = (int) lotto.stream().filter(inputNum::contains).count();
            boolean bonusMatch = lotto.contains(bonusNum);
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
