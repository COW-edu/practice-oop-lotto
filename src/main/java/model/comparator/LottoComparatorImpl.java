package model.comparator;

import model.data.LottoRepository;
import model.data.LottoWinning;
import model.lotto.Lotto;

import java.util.Iterator;

public class LottoComparatorImpl implements LottoComparator {

    private final LottoRepository lottoRepository;
    private final LottoWinning lottoWinning;

    public LottoComparatorImpl(LottoRepository lottoRepository, LottoWinning lottoWinning) {
        this.lottoRepository = lottoRepository;
        this.lottoWinning = lottoWinning;
    }

    @Override
    public void compare(Lotto tragetLotto, int bonusNumber) {

        Iterator<Lotto> lottoNumbers = lottoRepository.getLottoSaved().iterator();

        while (lottoNumbers.hasNext()) {
            Lotto currentNumber = lottoNumbers.next();
            int sameNumbers = 0;

            for (Integer element : tragetLotto.getNumbers()) {
                if (currentNumber.contains(element)) {
                    sameNumbers++;
                }
            }

            if (sameNumbers == 6) {
                lottoWinning.addFirst();
                continue;
            }
            if (sameNumbers == 5 && currentNumber.contains(bonusNumber)) {
                lottoWinning.addSecond();
                continue;
            }

            if (sameNumbers == 5) {
                lottoWinning.addThird();
                continue;
            }

            if (sameNumbers == 4) {
                lottoWinning.addFourth();
                continue;
            }

            if (sameNumbers == 3) {
                lottoWinning.addFifth();
            }
        }
    }
}
