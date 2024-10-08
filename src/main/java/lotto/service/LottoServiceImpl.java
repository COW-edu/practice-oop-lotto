package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.repository.LottoRepository;
import lotto.view.ErrorMessage;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoServiceImpl implements LottoService {

    private static final int LOOTO_AMOUNT = 1000;

    private final LottoRepository lottoRepository;
    private final LottoResult lottoResult;


    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
        this.lottoResult = new LottoResult();
    }

    @Override
    public void purchaseLottos(int amount) {
        Lotto.validatePurchaseAmount(amount);

        int numberOfLotto = amount / LOOTO_AMOUNT;
        IntStream.range(0, numberOfLotto).forEach(i -> {
            Lotto lotto = Lotto.createRandomLotto(); // Lotto도메인에서 팩토리 메소드 호출
            saveLottoNums(lotto);
        });
    }

    private void outputPurchasedLottos() {
        List<Lotto> purchasedLottos = lottoRepository.findAllLotto();
        OutputView.printTicketCount(purchasedLottos.size());
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers())); // 각 로또 번호 출력
    }

    @Override
    public void inputWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        try {
            WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);
            lottoRepository.saveWinningNumbers(winningNumbersObj);

            outputPurchasedLottos();
            checkAndPrintResults();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(ErrorMessage.ERROR_MESSAGE);
        }
    }


    public void saveLottoNums(Lotto lotto){
        lottoRepository.saveLotto(lotto);
    }

    public void checkAndPrintResults() {
        // 모든 구매 로또와 당첨 번호를 비교하는 메서드
        List<Lotto> purchasedLottos = lottoRepository.findAllLotto();
        WinningNumbers winningNumbers = lottoRepository.findWinningNumbers(); // 저장된 당첨 번호 가져오기
        int matchCount;

        for (Lotto lotto : purchasedLottos) {
            matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers.getNumbers()::contains)
                    .count();

            boolean hasBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            lottoResult.updateResult(matchCount, hasBonus); // 결과 업데이트
        }
        lottoResult.printResult(); // 결과 출력

    // 수익률 계산 및 출력
    double yield = lottoResult.calculateYield(purchasedLottos.size() * LOOTO_AMOUNT);
    System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
}

}
