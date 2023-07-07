package lotto.view;

import lotto.Message.InputMessage;
import lotto.Message.OutputMessage;
import lotto.Message.ResultMessage;
import lotto.controller.LottoController;

import java.util.List;

public class OutputView {
    private final int ONE_HUNDRED = 100;
    private final int ONE_THOUSAND = 1000;
    private final int RESULT_INDEX_THREE = 3;
    private final int RESULT_INDEX_SEVEN = 7;

    private final LottoController lottoController = new LottoController();

    public void outPutLottoList(int purchasedLottoCounts, InputMessage message) {
        System.out.println(String.format(message.getMessage(), purchasedLottoCounts));
        List<List<Integer>> lottoList = lottoController.createLottoList(purchasedLottoCounts);
        for (int index = 0; index < purchasedLottoCounts; index++) {
            System.out.println(lottoList.get(index));
        }
    }

    private String outPutResultComment(OutputMessage outputMessage, ResultMessage resultMessage, int [] winningLottoCountList, int correctNumberCount) {
        return  String.format(outputMessage.getMessage(), resultMessage.getWinningCount(),
                resultMessage.getBonusComment(), resultMessage.getWinningMoney(), winningLottoCountList[correctNumberCount-3]);
    }

    private int calculateTotalWinningMoney(ResultMessage resultMessage, int [] winningLottoCountList, int correctNumberCount) {
        int winningMoney = 0;
        winningMoney += Integer.parseInt(resultMessage.getWinningMoney().replaceAll(",", "")) * winningLottoCountList[correctNumberCount-3];
        return winningMoney;
    }

    public String outPutLottoTotalResult(OutputMessage outputMessage, int purchasedLottoCounts) {
        ResultMessage resultMessage;
        double totalWinningMoney = 0.0;
        System.out.println("\n당첨 통계\n---");
        int [] winningLottoCountList = lottoController.countWinningNumber(purchasedLottoCounts);
        for (int correctNumberCount = RESULT_INDEX_THREE; correctNumberCount <= RESULT_INDEX_SEVEN; correctNumberCount++) {
            resultMessage = ResultMessage.valueOf(correctNumberCount);
            System.out.println(outPutResultComment(outputMessage, resultMessage, winningLottoCountList, correctNumberCount));
            totalWinningMoney += calculateTotalWinningMoney(resultMessage, winningLottoCountList, correctNumberCount);
        }
        return String.format("%.1f", totalWinningMoney/(purchasedLottoCounts*ONE_THOUSAND)*ONE_HUNDRED);
    }

    public void rateOfLotteryWinnings(OutputMessage outputMessage, String totalWinningMoney) {
        System.out.println(String.format(outputMessage.getMessage(), totalWinningMoney));
    }
}
