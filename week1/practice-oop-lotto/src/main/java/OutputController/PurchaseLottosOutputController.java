package OutputController;

import model.Lotto;
import model.MModel;
import model.PurchasedLottos;
import viewInterface.OutputController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseLottosOutputController extends OutputController {
    @Override
    protected void setMessage(MModel<?> model) {
        if (!(model instanceof PurchasedLottos)) {
            throw new IllegalArgumentException("PurchasedLottos 모델이 필요합니다.");
        }

        PurchasedLottos purchasedLottos = (PurchasedLottos) model;
        List<Lotto> lottos = purchasedLottos.getData();

        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getData());
            sortedNumbers.sort(Integer::compareTo);

            sb.append(sortedNumbers).append("\n");
        }

        this.message = sb.toString().trim();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
