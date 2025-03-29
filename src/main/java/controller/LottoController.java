package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.LottoNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        int purchaseAmount=inputView.getPurchaseAmount();
        int numberOfLottos=calculateNumberOfLottos(purchaseAmount);
        outputView.printPurchaseCount(numberOfLottos);

        List<LottoNumber> lottoNumbers = generateRandomLottos(numberOfLottos);
        outputView.printLottoNumbers(lottoNumbers);

    }

    private int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount/1000;
    }

    private List<LottoNumber> generateRandomLottos(int numberOfLottos) {
        List<LottoNumber> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoList.add(new LottoNumber(randomNumbers));
        }
        return lottoList;
    }
}
