package outputController;

import global.Constants;
import global.MessageManager;
import model.MModel;
import model.WinningResult;
import viewController.OutputController;

public class WinningResultsOutputController extends OutputController {

    @Override
    public void setMessage(MModel<?> model) {
        if (!(model instanceof WinningResult)) {
            throw new IllegalArgumentException("WinningResult 모델이 필요합니다.");
        }

        WinningResult winningResult = (WinningResult) model;

        int fifthPrize = winningResult.getCount(Constants.WinningRank.FIFTH);
        int fourthPrize = winningResult.getCount(Constants.WinningRank.FOURTH);
        int thirdPrize = winningResult.getCount(Constants.WinningRank.THIRD);
        int secondPrize = winningResult.getCount(Constants.WinningRank.SECOND);
        int firstPrize = winningResult.getCount(Constants.WinningRank.FIRST);

        this.message = MessageManager.MessageFormatter.formatWinningStatistics(
                fifthPrize, fourthPrize, thirdPrize, secondPrize, firstPrize
        );
    }
}
