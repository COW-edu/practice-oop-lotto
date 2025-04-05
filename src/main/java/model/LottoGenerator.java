package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    //로또 번호 생성
    public static List<Integer> randomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_NUMBER.getValue(), LottoConfig.MAX_NUMBER.getValue(), LottoConfig.LOTTO_SIZE.getValue());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    //로또 여러장 생성
    public static LottoTickets buyLottos(int price) {
        int amount = calculateLottoAmount(price);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = randomLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return new LottoTickets(lottos);
    }

    //로또 구매 갯수 계산
    public static int calculateLottoAmount(int price) {
        if (price % LottoConfig.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getMessage());
        }
        return price / LottoConfig.LOTTO_PRICE.getValue();
    }
}
