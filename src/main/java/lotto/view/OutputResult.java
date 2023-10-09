package lotto.view;

import lotto.domain.Result;

public class OutputResult {
    private static final String OUTPUT_MESSAGE = "개 일치";

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        printOutputMessage(3, Result.FIFTH);
        printOutputMessage(4, Result.FOURTH);
        printOutputMessage(5, Result.THIRD);
        System.out.println(5 + "개 일치, 보너스 볼 일치 (" + Result.SECOND.getPrize() + ")" + "-" + Result.SECOND.getTotalCount() + "개");
        printOutputMessage(6, Result.FIRST);
        System.out.println();
    }

    private static void printOutputMessage(int n, Result result){
        System.out.println(n + "개 일치 (" + result.getPrize() + ")" + "-" + result.getTotalCount() + "개");
    }
}
