package lotto.view.output;

public class OutputRate {

    private static final String OUTPUT_MESSAGE_1 = "총 수익률은 ";
    private static final String OUTPUT_MESSAGE_2 = "%입니다.";
    private static final String ROUND_NUMBER = "%.1f";

    public static void printRate(double rate){
        System.out.print(OUTPUT_MESSAGE_1);
        System.out.printf(String.format(ROUND_NUMBER, rate));
        System.out.println(OUTPUT_MESSAGE_2);
    }

}
