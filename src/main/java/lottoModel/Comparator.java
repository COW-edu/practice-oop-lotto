package lottoModel;

import java.util.Iterator;
import java.util.List;

import static lottoModel.LottoRank.*;
import static lottoModel.LottoRank.FIFTH;

public class Comparator {

    public void lottoComparison(Lotto userLotto, int bonusNum) {
        Iterator<List<Integer>> lottoList = lottoSavedLooping();
        while (lottoList.hasNext()) {
            List<Integer> current = lottoList.next();
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
            if (sameNumbers == 5 && current.contains(bonusNum)) {
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

    private static Iterator<List<Integer>> lottoSavedLooping() {
        return LottoMaker.lottoSaved.iterator();
    }

}
