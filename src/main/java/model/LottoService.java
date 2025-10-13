package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {

    public Lotto makeLotto(int purchasedAmount){
        List<Integer> numbers = null;
        for (int i = 0; i < purchasedAmount; i++){
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        return new Lotto(numbers);
    }

    public LottoTickets purchaseLottos(int purchasedPrice) {
        LottoTickets purchasedTickets = new LottoTickets();
        int lottoCount = purchasedPrice / 1000;

        for(int i = 0; i < lottoCount; i++){
            Lotto lotto = makeLotto(lottoCount);
            lotto.sortNumbers();
            purchasedTickets.add(lotto);
        }

        return purchasedTickets;
    }

    public static int[] checkResult(LottoTickets hadLottos, Lotto winningLotto, int bonusNum) {
        int[] resultCounts = new int[LottoRank.values().length];

        List<Lotto> purchasedLottos = hadLottos.getLottos();

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(winningLotto.getNumbers(), purchasedLotto);
            boolean isBonusMatch = countMatchingNumbers(bonusNum, purchasedLotto);

            LottoRank rank = LottoRank.findRank(matchCount, isBonusMatch);

            if (rank != LottoRank.MISS) {
                int rankIndex = rank.ordinal();
                resultCounts[rankIndex]++;
            }
        }
        return resultCounts;
    }

    public static int countMatchingNumbers(List<Integer> winningLotto, Lotto purchasedLotto) {
        List<Integer> myNumbers = purchasedLotto.getNumbers(); // 내 로또 번호

        int matchCount = 0;
        int pointerIndex = 0;
        int winningIndex = 0;

        while (pointerIndex < 6 && winningIndex < 6) {
            int myNum = myNumbers.get(pointerIndex);
            int winningNum = winningLotto.get(winningIndex);

            if (myNum == winningNum) {
                // 1. 번호가 같으면 일치 개수 증가시키고 두 포인터 모두 이동
                matchCount++;
                pointerIndex++;
                winningIndex++;
            } else if (myNum < winningNum) {
                // 2. 내 번호가 작으면 내 포인터만 이동
                pointerIndex++;
            } else { // myNum > winningNum
                // 3. 당첨 번호가 작으면 당첨 포인터만 이동
                winningIndex++;
            }
        }
        return matchCount;
    }
    public static boolean countMatchingNumbers(int bonusNum, Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(bonusNum);
    }
}
