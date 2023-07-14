package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoResultRepository;
import lotto.model.WinningLottoNumberRepository;
import lotto.message.LottoExceptionMessage;

import java.util.List;

public class LottoServiceImpl implements LottoService {

  private final LottoNumberRepository lottoNumberRepository;
  private final WinningLottoNumberRepository winningLottoNumberRepository;
  private final LottoResultRepository lottoResultRepository;

  public LottoServiceImpl(LottoNumberRepository lottoNumberRepository,
      WinningLottoNumberRepository winningLottoNumberRepository,
      LottoResultRepository lottoResultRepository) {
    this.lottoNumberRepository = lottoNumberRepository;
    this.winningLottoNumberRepository = winningLottoNumberRepository;
    this.lottoResultRepository = lottoResultRepository;
  }

  private final int START_INCLUSIVE = 1;
  private final int END_INCLUSIVE = 45;
  private final int LOTTO_COUNT = 6;
  private final int LOTTO_COUNT_MINUS_ONE = 5;

  @Override
  public int calculatePurchaseAmount(int purchaseAmount, int oneThousand)
      throws IllegalArgumentException {
    boolean isNotDivided1000 = (purchaseAmount % oneThousand != 0);
    boolean isUnder1000 = (purchaseAmount < oneThousand);
    if (isUnder1000) {
      throw new IllegalArgumentException(LottoExceptionMessage.UNDER_1000.getMessage());
    }
    if (isNotDivided1000) {
      throw new IllegalArgumentException(LottoExceptionMessage.IS_NOT_DIVIDED_1000.getMessage());
    }
    return purchaseAmount / oneThousand;
  }

  @Override
  public List<Lotto> createRandomLottoNumbers(int purchasedLottoCounts) {
    for (int count = 0; count < purchasedLottoCounts; count++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
          LOTTO_COUNT);
      Lotto lotto = new Lotto(numbers);
      lottoNumberRepository.saveLottoList(lotto);
    }
    return lottoNumberRepository.findLottoList();
  }

  @Override
  public List<Integer> saveWinningLottoNumbers(String winningNumbers)
      throws IllegalArgumentException {
      return winningLottoNumberRepository.saveWinningLottoNumbers(
          Arrays.stream(winningNumbers.split(","))
          .map(String::trim)
          .map(Integer::parseInt)
          .collect(Collectors.toList()));
  }

  @Override
  public void saveBonusNumber(int bonusNumber) throws IllegalArgumentException {
    winningLottoNumberRepository.saveBonusNumber(bonusNumber);
    isInOneToFortyFive(bonusNumber);
  }

  private void isInOneToFortyFive(int integerLottoNumber) throws IllegalArgumentException {
    if (integerLottoNumber < START_INCLUSIVE || integerLottoNumber > END_INCLUSIVE) {
      throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_IN_1_45.getMessage());
    }
  }

  @Override
  public int[] countingWinningNumber(int purchasedLottoCounts) {
    List<Lotto> myLottoList = lottoNumberRepository.findLottoList();
    List<Integer> winningLottoNumbersList = winningLottoNumberRepository.findWinningLottoNumbersList();
    Lotto currentLottoList;
    for (int lottoIndex = 0; lottoIndex < purchasedLottoCounts; lottoIndex++) {
      currentLottoList = myLottoList.get(lottoIndex);
      int winningCount = calculateWinningCount(currentLottoList, winningLottoNumbersList);
      lottoResultRepository.saveLottoResult(winningCount);
    }
    return lottoResultRepository.findLottoResult();
  }

  private int calculateWinningCount(Lotto currentLottoList, List<Integer> winningLottoNumbersList) {
    int winningCount = 0;
    for (int LottoNumber : winningLottoNumbersList) {
      boolean isWinningNumber = currentLottoList.getNumbers().contains(LottoNumber);
        if (isWinningNumber) {
            winningCount++;
        }
    }
    if (winningCount == LOTTO_COUNT) {
      winningCount++;
    }
    boolean isBonus = currentLottoList.getNumbers()
        .contains(winningLottoNumberRepository.getBonusNumber());
    if (winningCount == LOTTO_COUNT_MINUS_ONE && isBonus) {
      winningCount++;
    }
    return winningCount;
  }
}
