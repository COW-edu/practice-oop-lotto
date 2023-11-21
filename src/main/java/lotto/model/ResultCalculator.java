package lotto.model;

import java.util.stream.Stream;

public class ResultCalculator {
    public ResultPrize calculateResult(WinningLotto winningLotto, Lottos lottos) {
        ResultPrize resultPrize = new ResultPrize();
        resultPrize.initializeResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = winningLotto.countMatchingNumbers(lotto);
            boolean containBonusNumber = winningLotto.containsBonusNumber(lotto);

            Result result = getResult(matchCount, containBonusNumber);
            resultPrize.plusTotalCount(result);
        }

        return resultPrize;
    }

    private Result getResult(int matchCount, boolean containBonusNumber) {
        return Stream.of(Result.values())
                .filter(result -> result.getRequiredMatchCount() == matchCount && (result != Result.SECOND || containBonusNumber))
                .findFirst()
                .orElse(null);
    }
}
