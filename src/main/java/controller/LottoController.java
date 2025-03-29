package controller;

import model.Lotto;
import model.LottoGenerator;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    //테스트용입니다..미완성
    public void run() {
        int price = InputView.inputPrice();
        List<Lotto> lottos = LottoGenerator.buyLottos(price);
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        //추가 예정
    }
}
