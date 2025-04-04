package OutputController;

import global.MessageManager;
import model.MModel;
import model.PurchaseInfo;
import viewInterface.OutputController;

public class PurchaseCountOutputController extends OutputController {

    @Override
    protected void setMessage(MModel<?> model) {
        if (!(model instanceof PurchaseInfo)) {
            throw new IllegalArgumentException("PurchaseInfo 모델이 필요합니다.");
        }

        PurchaseInfo purchaseInfo = (PurchaseInfo) model;
        int purchaseCount = purchaseInfo.getData();  // 구매 개수 가져오기

        this.message = String.valueOf(purchaseCount) + MessageManager.MessageType.INPUT_PURCHASE_COUNT;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
