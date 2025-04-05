package outputController;

import global.MessageManager;
import model.MModel;
import model.PurchaseInfo;
import viewController.OutputController;

public class PurchaseCountOutputController extends OutputController {

    @Override
    public void setMessage(MModel<?> model) {
        if (!(model instanceof PurchaseInfo)) {
            throw new IllegalArgumentException("PurchaseInfo 모델이 필요합니다.");
        }

        PurchaseInfo purchaseInfo = (PurchaseInfo) model;

        this.message = MessageManager.MessageFormatter.formatPurchaseCount(purchaseInfo.getData());
    }
}
