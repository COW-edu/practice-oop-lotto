package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    public ArrayList<Lotto> creatLotto(int price){
        int lottoCount = price / 1000;
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }

    public LottoRank checkLottoRank(ArrayList<Lotto> lottos, int[] winningNumbers, int bonusNumber) {
        int[] rank = new int[5];

        for (Lotto lotto : lottos) {
            int matchCount = 0;
            boolean hasBonus = false;

            for (int i = 0; i < 6; i++) {
                if (lotto.getNumbers()[i] == winningNumbers[i]) {
                    matchCount++;
                }
            }

            for (int number : lotto.getNumbers()) {
                if (number == bonusNumber) {
                    hasBonus = true;
                    break;
                }
            }

            if (matchCount == 6) {
                rank[0]++;
            } else if (matchCount == 5 && hasBonus) {
                rank[1]++;
            } else if (matchCount == 5) {
                rank[2]++;
            } else if (matchCount == 4) {
                rank[3]++;
            } else if (matchCount == 3) {
                rank[4]++;
            }
        }
        return new LottoRank(rank);
    }
}
