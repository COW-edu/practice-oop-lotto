package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoResultRepository;
import lotto.model.WinningLottoNumberRepository;

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

  private static final int START_INCLUSIVE = 1;
  private static final int END_INCLUSIVE = 45;
  private static final int LOTTO_COUNT = 6;
  private static final int UNIT = 1000;

  @Override
  public int calculatePurchaseAmount(int purchaseAmount)
      throws IllegalArgumentException {
    return purchaseAmount / UNIT;
  }

  @Override
  public void createRandomLottoNumbers(int purchasedLottoCounts) {
    for (int count = 0; count < purchasedLottoCounts; count++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
          LOTTO_COUNT);
      Lotto lotto = new Lotto(numbers);
      lottoNumberRepository.saveLottoList(lotto);
    }
  }

  @Override
  public List<Lotto> findRandomLottoNumbers() {
    return lottoNumberRepository.findLottoList();
  }

  @Override
  public void saveWinningLottoNumbers(String winningNumbers)
      throws IllegalArgumentException {
      winningLottoNumberRepository.saveWinningLotto(winningNumbers);
  }

  @Override
  public void saveBonusNumber(int bonusNumber) throws IllegalArgumentException {
    winningLottoNumberRepository.saveBonusNumber(bonusNumber);
  }

  @Override
  public int[] countingWinningNumber(int purchasedLottoCounts) {
    List<Lotto> myLottoList = lottoNumberRepository.findLottoList();
    List<Integer> winningLottoList = winningLottoNumberRepository.findWinningLotto();
    Lotto currentLottoList;
    for (int lottoIndex = 0; lottoIndex < purchasedLottoCounts; lottoIndex++) {
      currentLottoList = myLottoList.get(lottoIndex);
      int bonusNumber = winningLottoNumberRepository.getBonusNumber();
      int winningCount = currentLottoList.calculateWinningCount(winningLottoList, bonusNumber);
      lottoResultRepository.saveLottoResult(winningCount);
    }
    return lottoResultRepository.findLottoResult();
  }
}
