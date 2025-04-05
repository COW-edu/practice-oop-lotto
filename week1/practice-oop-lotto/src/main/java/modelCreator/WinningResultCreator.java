package modelCreator;

import controllerManager.ValidatorManager;
import global.Constants;
import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WinningResultCreator extends ValidatedModelCreator<WinningResult> {

    public WinningResultCreator(ValidatorManager validatorManager) {
        super(validatorManager);
    }

    @Override
    public WinningResult create(Optional<String> input, MModel<?>... models) {
        if (models.length != 3) {
            throw new IllegalArgumentException("WinningResult를 생성하려면 구매한 로또 리스트, 당첨번호, 보너스 번호가 필요합니다.");
        }

        PurchasedLottos purchasedLottos = (PurchasedLottos) models[0];
        WinningNumbers winningNumbers = (WinningNumbers) models[1];
        BonusNumber bonusNumber = (BonusNumber) models[2];

        return new WinningResult(calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber));
    }

    private Map<Constants.WinningRank, Integer> calculateWinningResults(
            PurchasedLottos purchasedLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {

        Map<Constants.WinningRank, Integer> winningCounts = new HashMap<>();
        List<Integer> winningNums = winningNumbers.getData();
        int bonusNum = bonusNumber.getData();

        for (Lotto lotto : purchasedLottos.getData()) {
            List<Integer> lottoNumbers = lotto.getData();
            int matchCount = (int) lottoNumbers.stream().filter(winningNums::contains).count();
            boolean bonusMatch = lottoNumbers.contains(bonusNum);

            Constants.WinningRank rank = Constants.WinningRank.getRank(matchCount, bonusMatch);
            winningCounts.put(rank, winningCounts.getOrDefault(rank, 0) + 1);
        }

        return winningCounts;
    }
}