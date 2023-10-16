package lotto.view.output;

public class OutputRate {

    private static final String PREFIX = "총 수익률은 ";
    private static final String POSTFIX = "%입니다.";
    private static final String ROUND_NUMBER = "%.1f";

    public void printRate(double rate){
        System.out.print(PREFIX);
        System.out.printf(String.format(ROUND_NUMBER, rate));
        System.out.println(POSTFIX);
    }

}
