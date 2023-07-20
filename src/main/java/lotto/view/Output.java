package lotto.view;

import lotto.Lotto;
import lotto.controller.LotteryHost;

import java.util.List;

public class Output {
    public static void print(String s) {
        System.out.println(s);
    }
    public static void printLottoNumbersAndQuantity(List<Lotto> lottoTickets, int numberOfLottery) {
        System.out.println(numberOfLottery + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            printLottoNumbers(lotto);
        }
    }
    private static void printLottoNumbers(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            System.out.print(lotto.getNumbers().get(i));
            if (i < lotto.getNumbers().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void printResult(LotteryHost lh, int numberOfLottery) {
        System.out.println("3개 일치 (5,000원) - " + lh.getResult()[0] + "개\n" +
                "4개 일치 (50,000원) - " + lh.getResult()[1] + "개\n" +
                "5개 일치 (1,500,000원) - " + lh.getResult()[2] + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lh.getResult()[3] + "개\n" +
                "6개 일치 (2,000,000,000원) - " + lh.getResult()[4] + "개\n" +
                "총 수익률은 " + lh.calculateRate(numberOfLottery) + "%입니다.");
    }
}
