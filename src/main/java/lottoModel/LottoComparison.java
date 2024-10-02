package lottoModel;

import java.util.Iterator;
import java.util.List;

import static lottoModel.LottoRank.*;
import static lottoModel.LottoRank.FIFTH;

public class LottoComparison {

    public void lottoComparison(Lotto userLotto, int bonusNum) {
        Iterator<List<Integer>> lottoList = lottoSavedLooping();
        while (lottoList.hasNext()) {
            List<Integer> current = lottoList.next();
            int sameNumbers = 0; // 매번 current에 대해 초기화

            // userLotto의 숫자와 current 비교
            for (Integer element : userLotto) { // userLotto에서 번호 가져오기
                if (current.contains(element)) {
                    sameNumbers++;
                }
            }
            if (sameNumbers == 6) {
                FIRST.setQuantity(FIRST.getQuantity() + 1);// 6개 일치
                continue;
            }
            if (sameNumbers == 5 && current.contains(bonusNum)) {
                SECOND.setQuantity(SECOND.getQuantity() + 1); // 5개 일치 + 보너스 번호
                continue;
            }

            if (sameNumbers == 5) {
                THIRD.setQuantity(THIRD.getQuantity() + 1); // 5개 일치
                continue;
            }

            if (sameNumbers == 4) {
                FOURTH.setQuantity(FOURTH.getQuantity() + 1); // 4개 일치
                continue;
            }

            if (sameNumbers == 3) {
                FIFTH.setQuantity(FIFTH.getQuantity() + 1);// 3개 일치
            }
        }
    }

    private static Iterator<List<Integer>> lottoSavedLooping() {
        return LottoMaker.lottoSaved.iterator();
    }

}
