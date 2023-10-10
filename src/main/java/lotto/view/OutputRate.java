package lotto.view;

import lotto.domain.Rate;

public class OutputRate {

    private static final String OUTPUT_MESSAGE_1 = "총 수익률은 ";
    private static final String OUTPUT_MESSAGE_2 = "%입니다.";
    private static final String ROUND_NUMBER = "%.1f";

    public static void printRate(Rate rate){
        System.out.print(OUTPUT_MESSAGE_1);
        System.out.printf(String.format(ROUND_NUMBER, rate.getRateOfReturn()));
        System.out.println(OUTPUT_MESSAGE_2);
    }

}
