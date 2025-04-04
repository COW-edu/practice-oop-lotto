package outputController;

import global.MessageManager;
import model.MModel;
import model.ProfitRate;
import viewInterface.OutputController;

public class ProfitRateOutputController extends OutputController {
    @Override
    public void setMessage(MModel<?> model) {
        if (!(model instanceof ProfitRate)) {
            throw new IllegalArgumentException("ProfitRate 모델이 필요합니다.");
        }

        ProfitRate profitRate = (ProfitRate) model;
        this.message = MessageManager.MessageFormatter.formatProfitRate(profitRate.getData());
    }
}
