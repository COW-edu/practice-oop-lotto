package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.message.WinningRankMessage;
import lotto.model.LottoNumberRepository;
import lotto.model.LottoResultRepository;
import lotto.model.WinningLottoNumberRepository;

import java.util.List;

public class LottoServiceImpl implements LottoService {

  private static final int START_INCLUSIVE = 1;
  private static final int END_INCLUSIVE = 45;
  private static final int LOTTO_COUNT = 6;
  private static final int CHANGE_PURCHASE_UNIT = 1000;
  private static final int INDEXING = 3;
  private static final int RANK_FIRST_INDEX = 4;

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

  @Override
  public int calculatePurchaseAmount(int purchaseAmount)
      throws IllegalArgumentException {
    return purchaseAmount / CHANGE_PURCHASE_UNIT;
  }

  @Override
  public void createRandomLottoNumbers(int purchasedLottoCounts) {

    for (int count = 0; count < purchasedLottoCounts; count++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
          LOTTO_COUNT);
      Lotto lotto = new Lotto(numbers);
      lottoNumberRepository.saveLotto(lotto);
    }
  }

  @Override
  public List<Lotto> findRandomLottoNumbers() {
    return lottoNumberRepository.findLottos();
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
  public List<Integer> countWinningNumber(int purchasedLottoCounts) {
    List<Lotto> myLottos = lottoNumberRepository.findLottos();
    int bonusNumber = winningLottoNumberRepository.getBonusNumber();
    Lotto currentLotto;

    for (int lottoIndex = 0; lottoIndex < purchasedLottoCounts; lottoIndex++) {
      currentLotto = myLottos.get(lottoIndex);
      int winningCount = winningLottoNumberRepository.calculateWinningCount(
          currentLotto.getNumbers());
      boolean isBonus = currentLotto.checkBonus(bonusNumber);
      lottoResultRepository.saveLottoResult(winningCount, isBonus);
    }
    return lottoResultRepository.findLottoResults();
  }

  @Override
  public double calculateTotalWinningMoney(WinningRankMessage winningRankMessage,
      List<Integer> winningLottoCountList,
      int winningCount) {
    int winningIndex = winningCount - INDEXING;

    if (winningCount == LOTTO_COUNT) {
      winningIndex = RANK_FIRST_INDEX;
    }
    return Integer.parseInt(winningRankMessage.getWinningMoney().replaceAll(",", ""))
        * winningLottoCountList.get(winningIndex);
  }
}
