package View;

import Model.Money;

import static Model.Prize.*;

public class Output {
    public void printMoneyMessage() {
        System.out.print("금액을 입력하시오: ");
    }
    public void printLottoNumberMessage() {
        System.out.print("로또 번호를 입력하시오: ");
    }
    public void printBonusNumberMessage() {
        System.out.print("보너스 번호를 입력하시오: ");
    }
    public void printBuyLottoMessage(){
        System.out.println(Money.getAmountOfLotto() + "개를 구매했습니다.");
    }
    public void printResult(int[] matchingCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", matchingCounts[WIN_FIFTH_PRIZE]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchingCounts[WIN_FOURTH_PRIZE]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchingCounts[WIN_THIRD_PRIZE]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchingCounts[WIN_SECOND_PRIZE]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchingCounts[WIN_FIRST_PRIZE]);
        System.out.println("");
    }

    public void printProfit(double totalProfitRate) {
        System.out.printf("총 수익률은 %.1f %%입니다.", totalProfitRate);
    }
}
