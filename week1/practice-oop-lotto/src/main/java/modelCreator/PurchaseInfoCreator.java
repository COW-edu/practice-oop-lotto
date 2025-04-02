package modelCreator;

import model.MModel;
import model.PurchaseInfo;

import java.util.Optional;

public class PurchaseInfoCreator implements ModelCreator<PurchaseInfo> {

    @Override
    public PurchaseInfo create(Optional<String> input, MModel<?>... models) {
        int purchasePrice = Integer.parseInt(input.orElse("0"));
        return new PurchaseInfo(purchasePrice);
    }
}