package view;

import model.data.LottoWinning;
import model.lotto.Unit;
import static model.lotto.LottoRank.*;
import static view.OutputMessage.*;

public class LottoOutputImpl implements LottoOutput {
    private final LottoWinning lottoWinning;

    public LottoOutputImpl(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    @Override
    public void resultPrint(int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printEachMessage(FIFTH_OUTPUT, lottoWinning.getQuantity(FIFTH));
        printEachMessage(FOURTH_OUTPUT, lottoWinning.getQuantity(FOURTH));
        printEachMessage(THIRD_OUTPUT, lottoWinning.getQuantity(THIRD));
        printEachMessage(SECOND_OUTPUT, lottoWinning.getQuantity(SECOND));
        printEachMessage(FIRST_OUTPUT, lottoWinning.getQuantity(FIRST));

        double totalPricePercent = getTotalPrizePercent(inputMoney);
        System.out.println("총 수익률은 " + totalPricePercent + "% 입니다.");
    }

    private double getTotalPrizePercent(int inputMoney) {
        return Math.round(((double) getTotalPrize() / inputMoney * Unit.PERCENT_UNIT.getValue()) * 10) / 10.0;
    }

    private int getTotalPrize() {
        return FIFTH.getLottoPrize() * lottoWinning.getQuantity(FIFTH) +
                FOURTH.getLottoPrize() * lottoWinning.getQuantity(FOURTH) +
                THIRD.getLottoPrize() * lottoWinning.getQuantity(THIRD) +
                SECOND.getLottoPrize() * lottoWinning.getQuantity(SECOND) +
                FIRST.getLottoPrize() * lottoWinning.getQuantity(FIRST);
    }

    private void printEachMessage(OutputMessage output, int lottoWinning) {
        System.out.println(String.format(output.getMessage(), lottoWinning));
    }
}
