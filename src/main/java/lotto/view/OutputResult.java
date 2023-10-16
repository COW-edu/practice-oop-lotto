package lotto.view;

import lotto.domain.Result;
import lotto.domain.ResultPrize;

public class OutputResult {

    public static void printResult(ResultPrize resultPrize) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Result result : Result.values()) {
            printOutputMessage(result, resultPrize);
        }
    }

    private static void printOutputMessage(Result result, ResultPrize resultPrize){
        if(result == Result.SECOND) {
            System.out.println(result.getRequiredMatchCount() + "개 일치 , 보너스 볼 일치 (" + result.getPrize() + ")" + "-" + resultPrize.getResultPrize().get(result) + "개");
            return;
        }
        System.out.println(result.getRequiredMatchCount() + "개 일치 (" + result.getPrize() + ")" + "-" + resultPrize.getResultPrize().get(result) + "개");
    }
}
