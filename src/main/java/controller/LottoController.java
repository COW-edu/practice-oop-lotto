package controller;

import model.Lotto;
import model.LottoGenerator;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    //테스트용입니다..미완성
    public void run() {
        int price = InputView.inputPrice();
        List<Lotto> lottos = LottoGenerator.buyLottos(price);
        displayLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        //추가 예정
    }

    public void displayLottos(List<Lotto> lottos) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getNumbers());
        }
        OutputView.printLottos(lottos.size(), lottoNumbers);
    }
}
