package view;

import domain.Lotto;
import domain.Result;
import enums.Rank;
import java.util.List;

public class OutputView {
    private static final List<Rank> PRINT_ORDER = List.of(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.SECOND,
            Rank.FIRST
    );

    public void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public void printResult(Result result) {
        System.out.println("\n당첨 통계\n---");

        for (Rank rank : PRINT_ORDER) {
            System.out.println(rank.getDisplayString() + result.getCount(rank) + "개");
        }
        // 8-2. getReturnRate() 호출
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getReturnRate());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
