package controller;

import model.WinningLotto;
import model.WinningLottoRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class WinningLottoController implements Controller{

    private static final WinningLottoRepository winningLottoRepository = WinningLottoRepository.getInstance();

    private WinningLotto makeWinning(List<Integer> numbers, int bonus) {
        return new WinningLotto(numbers, bonus);
    }

    @Override
    public void service(InputView inputView, OutputView outputView) {
        List<Integer> numbers = inputView.requestWinning();
        int bonus = inputView.requestBonus();
        WinningLotto winningLotto = makeWinning(numbers, bonus);
        winningLottoRepository.save(winningLotto);
    }
}
