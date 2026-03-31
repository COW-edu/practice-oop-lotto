package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.EnumMap;

public class Application {
    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void start() {
        int money = inputMoney();
        List<Lotto> myLottos = buyLottos(money);
        printLottos(myLottos);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonus = inputBonusNumber(winningNumbers);

        Map<LottoRank, Integer> stats = calculateStats(myLottos, winningNumbers, bonus);
        printResult(stats, money);
    }

    private static int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static List<Lotto> buyLottos(int money) {
        int count = money / 1000;
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try {
            String[] split = Console.readLine().split(",");
            List<Integer> nums = new ArrayList<>();
            for (String s : split) {
                nums.add(Integer.parseInt(s.trim()));
            }
            return nums;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            int bonus = Integer.parseInt(Console.readLine());
            validateBonus(winningNumbers, bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateBonus(List<Integer> winningNumbers, int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복됩니다.");
        }
    }

    private static Map<LottoRank, Integer> calculateStats(List<Lotto> lottos, List<Integer> win, int bonus) {
        Map<LottoRank, Integer> stats = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            int match = countMatch(lotto, win);
            LottoRank rank = matchToRank(match, lotto.hasNumber(bonus));
            stats.put(rank, stats.getOrDefault(rank, 0) + 1);
        }
        return stats;
    }

    private static int countMatch(Lotto lotto, List<Integer> win) {
        int count = 0;
        for (int n : win) {
            if (lotto.hasNumber(n)) count++;
        }
        return count;
    }

    private static LottoRank matchToRank(int match, boolean hasBonus) {
        if (match == 6) return LottoRank.FIRST;
        if (match == 5 && hasBonus) return LottoRank.SECOND;
        if (match == 5) return LottoRank.THIRD;
        if (match == 4) return LottoRank.FOURTH;
        if (match == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }

    private static void printResult(Map<LottoRank, Integer> stats, int money) {
        System.out.println("\n당첨 통계\n---");
        long totalPrize = 0;
        LottoRank[] showOrder = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};
        for (LottoRank r : showOrder) {
            int count = stats.getOrDefault(r, 0);
            System.out.println(r.getMessage() + count + "개");
            totalPrize += (long) r.getPrize() * count;
        }
        double profitRate = (double) totalPrize / money * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}