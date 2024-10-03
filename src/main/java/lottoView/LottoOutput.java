package lottoView;

import lottoModel.LottoMaker;
import lottoModel.LottoRank;
import lottoModel.OutputMessage;
import lottoModel.UNIT;

import static lottoModel.LottoRank.*;
import static lottoModel.OutputMessage.*;

public class LottoOutput {


    public void generateLottoNum(int inputMoney) {
        int unitMoney = 1000;
        int amount = inputMoney / unitMoney;
        System.out.println(String.format(AMOUNT_OUTPUT.getMessage(), amount));
        LottoMaker.generate(amount);
    }



    public void print(int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printEachMessage(FIFTH,FIFTH_OUTPUT);
        printEachMessage(FOURTH,FOURTH_OUTPUT);
        printEachMessage(THIRD,THIRD_OUTPUT);
        printEachMessage(SECOND,SECOND_OUTPUT);
        printEachMessage(FIRST,FIRST_OUTPUT);

        double totalPrice = Math.round(((FIFTH.getLottoTotalPrize()
                + FOURTH.getLottoTotalPrize()
                + THIRD.getLottoTotalPrize()
                + SECOND.getLottoTotalPrize()
                + FIRST.getLottoTotalPrize()) / inputMoney * UNIT.PERCENT_UNIT) * 10) / 10.0;
        System.out.println("총 수익률은 " + totalPrice + "% 입니다.");


    }

    private static void printEachMessage(LottoRank rank, OutputMessage output) {
        System.out.println(String.format(output.getMessage(),rank.getQuantity()));
    }
}
