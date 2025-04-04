package modelCreator;

import global.Constants;
import model.MModel;
import model.ProfitRate;
import model.PurchaseInfo;
import model.WinningResult;

import java.util.Map;
import java.util.Optional;

public class ProfitRateCreator implements ModelCreator<ProfitRate> {

    @Override
    public ProfitRate create(Optional<String> input, MModel<?>... models) {
        if (models.length != 2 ||
                !(models[0] instanceof WinningResult) ||
                !(models[1] instanceof PurchaseInfo)) {
            throw new IllegalArgumentException("ProfitRate를 생성하려면 WinningResult와 PurchaseInfo 모델이 필요합니다.");
        }

        WinningResult winningResult = (WinningResult) models[0];
        PurchaseInfo purchaseInfo = (PurchaseInfo) models[1];

        double totalPrizeMoney = calculateTotalPrize(winningResult.getData());
        int totalPurchasePrice = purchaseInfo.getPurchasePrice();

        double rawProfitRate = (totalPrizeMoney / totalPurchasePrice) * 100;

        double roundedProfitRate = Math.round(rawProfitRate * 10.0) / 10.0;

        return new ProfitRate(roundedProfitRate);
    }

    private double calculateTotalPrize(Map<Constants.WinningRank, Integer> winningCounts) {
        double total = 0;

        for (Map.Entry<Constants.WinningRank, Integer> entry : winningCounts.entrySet()) {
            Constants.WinningRank rank = entry.getKey();
            int count = entry.getValue();
            total += (long) rank.getPrizeMoney() * count;
        }

        return total;
    }
}