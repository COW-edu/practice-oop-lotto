package lotto.view.output;

import lotto.domain.Result;
import lotto.domain.ResultPrize;

public class OutputResult {

    private final static String WINNING_STATIC_MESSAGE = "당첨 통계";
    private final static String CONTOUR_MESSAGE = "---";
    private final static String MATCHING_COUNT_MESSAGE = "개 일치";
    private final static String MATCHING_BONUSBALL_MESSAGE = "보너스 볼 일치";
    private final static String COUNT_MESSAGE = "개";

    public static void printResult(ResultPrize resultPrize) {
        System.out.println(WINNING_STATIC_MESSAGE);
        System.out.println(CONTOUR_MESSAGE);

        for (Result result : Result.values()) {
            printOutputMessage(result, resultPrize);
        }
    }

    private static void printOutputMessage(Result result, ResultPrize resultPrize){
        if(result == Result.SECOND) {
            System.out.println(result.getRequiredMatchCount() + MATCHING_COUNT_MESSAGE +"," + MATCHING_BONUSBALL_MESSAGE + " (" + result.getPrize() + ")" + "-" + resultPrize.getResultPrize().get(result) + COUNT_MESSAGE);
            return;
        }
        System.out.println(result.getRequiredMatchCount() + MATCHING_COUNT_MESSAGE + "(" + result.getPrize() + ")" + "-" + resultPrize.getResultPrize().get(result) + COUNT_MESSAGE);
    }
}
