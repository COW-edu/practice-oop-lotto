package modelCreator;

import camp.nextstep.edu.missionutils.Randoms;
import global.Constants;
import model.Lotto;
import model.MModel;
import model.PurchaseInfo;
import model.PurchasedLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchasedLottosCreator implements ModelCreator<PurchasedLottos> {

    @Override
    public PurchasedLottos create(Optional<String> input, MModel<?>... models) {
        if (models.length != 1 || !(models[0] instanceof PurchaseInfo)) {
            throw new IllegalArgumentException("PurchasedLottos를 생성하려면 PurchaseInfo 모델이 필요합니다.");
        }

        PurchaseInfo purchaseInfo = (PurchaseInfo) models[0];
        int purchaseCount = purchaseInfo.getData();

        return new PurchasedLottos(generateLottos(purchaseCount));
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateSingleLotto());
        }
        return lottos;
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }
}