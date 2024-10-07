package lotto_model;

import java.util.Iterator;

import static lotto_model.LottoRank.*;
import static lotto_model.LottoRank.FIFTH;

public class LottoComparator {

    private final LottoRepository lottoRepository;

    public LottoComparator(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void compare(Lotto userLotto, int bonusNumber) {
        Iterator<Lotto> lottoNumbers = lottoRepository.getLottoSaved().iterator();
        while (lottoNumbers.hasNext()) {
            Lotto current = lottoNumbers.next();
            int sameNumbers = 0;

            for (Integer element : userLotto) {
                if (current.contains(element)) {
                    sameNumbers++;
                }
            }
            if (sameNumbers == 6) {
                FIRST.setQuantity(FIRST.getQuantity() + 1);
                continue;
            }
            if (sameNumbers == 5 && current.contains(bonusNumber)) {
                SECOND.setQuantity(SECOND.getQuantity() + 1);
                continue;
            }

            if (sameNumbers == 5) {
                THIRD.setQuantity(THIRD.getQuantity() + 1);
                continue;
            }

            if (sameNumbers == 4) {
                FOURTH.setQuantity(FOURTH.getQuantity() + 1);
                continue;
            }

            if (sameNumbers == 3) {
                FIFTH.setQuantity(FIFTH.getQuantity() + 1);
            }
        }
    }
}
