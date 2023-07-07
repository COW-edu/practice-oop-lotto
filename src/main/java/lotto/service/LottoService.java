package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoResultRepository;
import lotto.model.WinningLottoNumberRepository;
import lotto.message.LottoExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoService {

    private final LottoNumberRepository lottoNumberRepository = new LottoNumberRepository();
    private final WinningLottoNumberRepository winningLottoNumberRepository = new WinningLottoNumberRepository();
    private final LottoResultRepository lottoResultRepository = new LottoResultRepository();

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int LOTTO_COUNT = 6;
    private final int LOTTO_COUNT_MINUS_ONE = 5;


    public int calculatePurchaseAmount(int purchaseAmount, int oneThousand) throws IllegalArgumentException{
        boolean isNotDivided1000 = (purchaseAmount % oneThousand != 0);
        boolean isUnder1000 = (purchaseAmount < oneThousand);
        if (isUnder1000) {
            throw new IllegalArgumentException(LottoExceptionMessage.UNDER_1000.getMessage());
        } else if (isNotDivided1000) {
            throw new IllegalArgumentException(LottoExceptionMessage.IS_NOT_DIVIDED_1000.getMessage());
        }
        return purchaseAmount / oneThousand;
    }
    public List<List<Integer>> createRandomLottoNumbers(int purchasedLottoCounts) {
        for (int count = 0; count < purchasedLottoCounts; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT);
            lottoNumberRepository.saveLottoList(numbers);
        }
        return lottoNumberRepository.findLottoList();
    }
    private void isInOneToFortyFive(int integerLottoNumber) throws IllegalArgumentException {
        if (integerLottoNumber < START_INCLUSIVE || integerLottoNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_IN_1_45.getMessage());
        }
    }
    public List<Integer> saveWinningLottoNumbers(String winningNumbers) throws IllegalArgumentException {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumbers, ",");
        List<Integer> integerWinningNumber = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            int integerLottoNumber = Integer.parseInt(stringTokenizer.nextToken());
            isInOneToFortyFive(integerLottoNumber);
            integerWinningNumber.add(integerLottoNumber);
        }
        return winningLottoNumberRepository.saveWinningLottoNumbers(integerWinningNumber);
    }
    public List<Integer> saveBonusNumber(int bonusNumber) throws IllegalArgumentException{
        isInOneToFortyFive(bonusNumber);
        return winningLottoNumberRepository.saveBonusNumber(bonusNumber);
    }
    private int calculateWinningCount(List<Integer> currentLottoList, List<Integer> winningLottoNumbersList) {
        int winningCount = 0;
        for (int LottoIndex = 0; LottoIndex < LOTTO_COUNT; LottoIndex++) {
            boolean isWinningNumber = currentLottoList.contains(winningLottoNumbersList.get(LottoIndex));
            if (isWinningNumber) winningCount++;
        }
        if (winningCount == LOTTO_COUNT) winningCount++;
        boolean isBonus = currentLottoList.contains(winningLottoNumbersList.get(LOTTO_COUNT));
        if (winningCount == LOTTO_COUNT_MINUS_ONE && isBonus) winningCount++;
        return winningCount;
    }
    public int [] countingWinningNumber(int purchasedLottoCounts) {
        List<List<Integer>> myLottoList = lottoNumberRepository.findLottoList();
        List<Integer> winningLottoNumbersList = winningLottoNumberRepository.findWinningLottoNumbersList();
        List<Integer> currentLottoList;
        for (int lottoIndex = 0; lottoIndex < purchasedLottoCounts; lottoIndex++) {
            currentLottoList = myLottoList.get(lottoIndex);
            int winningCount = calculateWinningCount(currentLottoList, winningLottoNumbersList);
            lottoResultRepository.saveLottoResult(winningCount);
        }
        return lottoResultRepository.findLottoResult();
    }
}
