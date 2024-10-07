package lotto_view;

import lotto_model.Lotto;
import lotto_model.LottoRank;
import lotto_model.Unit;

import static lotto_model.LottoRank.*;
import static lotto_view.OutputMessage.*;

public class LottoOutput {
    public void resultPrint(int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printEachMessage(FIFTH,FIFTH_OUTPUT);
        printEachMessage(FOURTH,FOURTH_OUTPUT);
        printEachMessage(THIRD,THIRD_OUTPUT);
        printEachMessage(SECOND,SECOND_OUTPUT);
        printEachMessage(FIRST,FIRST_OUTPUT);

        double totalPrice = getTotalPrice(inputMoney);
        System.out.println("총 수익률은 " + totalPrice + "% 입니다.");
    }

    private static double getTotalPrice(int inputMoney) {
        return Math.round(((FIFTH.getLottoTotalPrize() +
                FOURTH.getLottoTotalPrize() +
                THIRD.getLottoTotalPrize() +
                SECOND.getLottoTotalPrize() +
                FIRST.getLottoTotalPrize()) / inputMoney * Unit.PERCENT_UNIT.getValue()) * 10) / 10.0;
    }

    private void printEachMessage(LottoRank rank, OutputMessage output) {
        System.out.println(String.format(output.getMessage(),rank.getQuantity()));
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
