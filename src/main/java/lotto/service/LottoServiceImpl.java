package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.repository.LottoRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;
    private static final int LOOTO_AMOUNT = 1000;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
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
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage();
        }
    }

    @Override
    public void saveWinningNumbers(WinningNumbers winningNumbers) {
        lottoRepository.saveWinningNumbers(winningNumbers);
    }

    public void saveLottoNums(Lotto lotto){
        lottoRepository.saveLotto(lotto);
    }

}
